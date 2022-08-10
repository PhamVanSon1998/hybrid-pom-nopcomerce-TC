package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjects.CustomerInforPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class Search extends AbtractTest {
	WebDriver driver;
	CustomerInforPage customerInforPageObject;
	HomePage homePageObject;
	LoginPage loginPageObject;
	SearchPage searchPageObject;

	@Parameters({ "browser", "url", "emailLogin" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues, String emailLogin) {
		driver = getBrowserDriver(browserName, urlValues,emailLogin);
	}
	
	@Test
	public void TC_01_Login_Success() {
		log.info("Login Success Step-01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Login Success Step- 02: Click to Login link and navigate to Login Page");
		loginPageObject = homePageObject.clickLoginLink();
		
		log.info("Login Success Step-03: Input to Email Textbox " + email);
		loginPageObject.inputToEmailTextbox(email);
		
		log.info("Login Success Step-04: Input to newPassword Textbox " + newpassword);
		loginPageObject.inputToPassword(newpassword);
		
		log.info("Login Success Step-05: Click to Login Button and navigate to Home Page" );
		homePageObject= loginPageObject.clickToLoginButton();
		
		log.info("Login Success Step-06: Verify My Acount link Displayed");
		verifyTrue(loginPageObject.verifyMyaccountLinkDisplay());
	}
	
	@Test
	public void TC_02_Search_With_Empty_Data() {
		log.info("Search with Empty Data Step-01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Search with Empty Data Step-02: Click Search link and navigate to Search Page");
		searchPageObject = homePageObject.clickSearchLink("Search");
		
		log.info("Search with Empty Data Step-03: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info("Search with Empty Data Step-04: Verify Message error Displayed");
		verifyEquals(searchPageObject.verifyMessageErrorDisplayed(),"Search term minimum length is 3 characters");
	}
	
	@Test
	public void TC_03_Search_With_Data_Not_Exist() {
		log.info("Search with Data not Exist Step-01: Input to Search Keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Macbook 1234556");
		
		log.info("Search with Data not Exist Step-02: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info("Search with Data not Exist Step-03: Verify Message error Displayed");
		verifyEquals(searchPageObject.verifyMessageErrorDisplayed(),"No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_04_Search_With_Data_Relative() {
		log.info("Search with Data Relative Step-01: Input to Search Keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Lenovo");
		
		log.info("Search with Data Relative Step-02: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info("Search with Data Relative Step-03: Verify Product Item Displayed");
		verifyTrue(searchPageObject.verifyProductItemDisplayed(2));
	}
	
	@Test
	public void TC_05_Search_With_Data_Absolute() {
		log.info("Search with Data Absolute Step-01: Input to Search Keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro 13-inch");
		
		log.info("Search with Data Absolute Step-02: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info("Search with Data Absolute Step-03: Verify Product Item Displayed");
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(1));
		
		log.info("Search with Data Absolute Step-04: Verify Product Name Displayed");
		Assert.assertTrue(searchPageObject.verifyProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_06_Advanced_Search_With_Parent_Categories() {
		log.info(" Advanced Search with Parent Categories Step-01: Check to Advanced Search");
		searchPageObject.checkToAdvancedSearch();
		
		log.info(" Advanced Search with Parent Categories Step-02: Input to Search keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info(" Advanced Search with Parent Categories Step-03: Select Category Dropdown");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		
		log.info(" Advanced Search with Parent Categories Step-04: Uncheck sub Category checkbox");
		searchPageObject.unCheckSubCategoryCheckbox();
		
		log.info(" Advanced Search with Parent Categories Step-05: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info(" Advanced Search with Parent Categories Step-06: Verify Message error Displayed");
		verifyEquals(searchPageObject.verifyMessageErrorDisplayed(),"No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_07_Advanced_Search_With_Sub_Categories() {
		log.info(" Advanced Search with Sub Categories Step-01: Check to Advanced Search");
		searchPageObject.checkToAdvancedSearch();
		
		log.info(" Advanced Search with Sub Categories Step-02: Input to Search Keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info(" Advanced Search with Sub Categories Step-03: Select Category Dropdown");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		
		log.info(" Advanced Search with Sub Categories Step-04: Check sub Category checkbox");
		searchPageObject.CheckSubCategoryCheckbox();
		
		log.info(" Advanced Search with Sub Categories Step-05: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info(" Advanced Search with Sub Categories Step-06: Verify Product Item Displayed");
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(1));
		
		log.info(" Advanced Search with Sub Categories Step-07: Verify Product Name Displayed");
		Assert.assertTrue(searchPageObject.verifyProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_08_Advanced_Search_With_Incorrect_Manufacturer() {
		log.info(" Advanced Search with Incorect Manufacturer Step-01: Check to Advanced Search");
		searchPageObject.checkToAdvancedSearch();
		
		log.info(" Advanced Search with Incorect Manufacturer Step-02: Input to Search Keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info(" Advanced Search with Incorect Manufacturer Step-03: Select Category Dropdown");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		
		log.info(" Advanced Search with Incorect Manufacturer Step-04: Check sub Category checkbox");
		searchPageObject.CheckSubCategoryCheckbox();
		
		log.info(" Advanced Search with Incorect Manufacturer Step-04: Select Category Dropdown");
		searchPageObject.selectCategoryDropdown("HP","Manufacturer:");
		
		log.info(" Advanced Search with Incorect Manufacturer Step-05: Click to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info(" Advanced Search with Incorect Manufacturer Step-06: Verify Message error Displayed");
		verifyEquals(searchPageObject.verifyMessageErrorDisplayed(),"No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_09_Advanced_Search_With_Correct_Manufacturer() {
		log.info(" Advanced Search with Correct Manufacturer Step-01: Check to Advanced Search");
		searchPageObject.checkToAdvancedSearch();
		
		log.info(" Advanced Search with Correct Manufacturer Step-02: Input to Search Keyword Textbox");
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		
		log.info(" Advanced Search with Correct Manufacturer Step-03: Select Category Dropdown");
		searchPageObject.selectCategoryDropdown("Computers","Category:");
		
		log.info(" Advanced Search with Correct Manufacturer Step-04: Check sub Category checkbox");
		searchPageObject.CheckSubCategoryCheckbox();
		
		log.info(" Advanced Search with Correct Manufacturer Step-05: Select Category Dropdown");
		searchPageObject.selectCategoryDropdown("Apple","Manufacturer:");
		
		log.info(" Advanced Search with Correct Manufacturer Step-06: Check to Search Button");
		searchPageObject.clickToSearchButton();
		
		log.info(" Advanced Search with Correct Manufacturer Step-07: Verify Product Item Displayed");
		Assert.assertTrue(searchPageObject.verifyProductItemDisplayed(1));
		
		log.info(" Advanced Search with Correct Manufacturer Step-08: Verify Product Name Displayed");
		Assert.assertTrue(searchPageObject.verifyProductNameDisplayed("Apple MacBook Pro 13-inch"));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
