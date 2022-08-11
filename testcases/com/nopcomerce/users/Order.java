package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjects.CompareProductsListPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ShoppingCartPage;
import pageObjects.WishlistPage;

public class Order extends AbtractTest {

	WebDriver driver;

	@Parameters({ "browser", "url", "emailLogin" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues, String emailLogin) {
		driver = getBrowserDriver(browserName, urlValues, emailLogin);
	}

	HomePage homePageObject;
	LoginPage loginPageObject;
	WishlistPage wishlistPageObject;
	ShoppingCartPage shoppingCartPageObject;
	CompareProductsListPage compareProductsListPageObject;

	@Test
	public void TC_01_Login() {
		log.info("Login Success Step-01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);

		log.info("Login Success Step- 02: Click to Login link and navigate to Login Page");
		loginPageObject = homePageObject.clickLoginLink();

		log.info("Login Success Step-03: Input to Email Textbox " + email);
		loginPageObject.inputToEmailTextbox(email);

		log.info("Login Success Step-04: Input to newPassword Textbox " + newpassword);
		loginPageObject.inputToPassword(newpassword);

		log.info("Login Success Step-05: Click to Login Button and navigate to Home Page");
		homePageObject = loginPageObject.clickToLoginButton();

		log.info("Login Success Step-06: Verify My Acount link Displayed");
		verifyTrue(loginPageObject.verifyMyaccountLinkDisplay());
	}

	@Test
	public void TC_02_Add_Product_To_Cart() {
		log.info("Login Success Step-01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);

		log.info("Login Success Step- 02: Click to Login link and navigate to Login Page");
		homePageObject.moveToComputersLink();

		log.info("Login Success Step-03: Input to Email Textbox " + email);
		homePageObject.clickToProductTypeLink("Desktops");

		log.info("Login Success Step-04: Input to newPassword Textbox " + newpassword);
		homePageObject.clicktoProductName("Build your own computer");

		log.info("Login Success Step-05: Click to Login Button and navigate to Home Page");
		homePageObject.selectComponetOfCPUDropdown("Processor","2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("Login Success Step-06: Verify My Acount link Displayed");
		homePageObject.selectComponetOfCPUDropdown("RAM","8GB [+$60.00]");
		
		log.info("Login Success Step-07: Check type HDD Checkbox");
		homePageObject.checkComponetOfCPUCheckbox("HDD","400 GB [+$100.00]");
		
		log.info("Login Success Step-08: Check type OS Checkbox");
		homePageObject.checkComponetOfCPUCheckbox("OS","Vista Premium [+$60.00]");
		
//		log.info("Login Success Step-09: Check to type Software Radiobutton");
//		homePageObject.checktoSoftwareRadioButton("Microsoft Office [+$50.00]");
		
		log.info("Login Success Step-10: Check to type Software Radiobutton");
		homePageObject.checktoSoftwareRadioButton("Acrobat Reader [+$10.00]");
		
		log.info("Login Success Step-11: Check to type Software Radiobutton");
		homePageObject.checktoSoftwareRadioButton("Total Commander [+$5.00]");
		
		log.info("Login Success Step-12: Input to Quantity AddToCart Textbox");
		homePageObject.inputToQuantityAddToCartTextbox("1");
		
		log.info("Login Success Step-13: Click AddToCart Button");
		homePageObject.clickAddToCartButton();
		
		log.info("Login Success Step-14: Verify Message AddToCart Success");
		verifyEquals(homePageObject.isMessageAddToSuccess(), "shopping cart");
		
		log.info("Login Success Step-15: Click Close Message AddToCart Success");
		homePageObject.clickCloseMessageAddToSuccess();
		
		log.info("Login Success Step-16: Verify Quantity Product In ShoppingCart");
		verifyEquals(homePageObject.isQuantityProductInShoppingCart(), "(1)");
		
		log.info("Login Success Step-17: Hover ShoppingCart link");
		homePageObject.moveToShoppingCartLink();
		
		log.info("Login Success Step-18: Verify Text When Hover ShoppingCart link Displayed");
		verifyEquals(homePageObject.isTextWhenHoverShoppingCartLinkDisplayed(), "1 item(s)");
		
		log.info("Login Success Step-19: Verify Infor When Hover ShoppingCart link Displayed");
		verifyTrue(homePageObject.isInforProductWhenHoverShoppingCartLinkDisplayed("Build your own computer","2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]","8GB [+$60.00]","400 GB [+$100.00]","Vista Premium [+$60.00]","Microsoft Office [+$50.00]","Acrobat Reader [+$10.00]"));
		
		log.info("Login Success Step-20: Verify Infor SubTotal When Hover ShoppingCart link Displayed");
		verifyEquals(homePageObject.isInforSubtotalWhenHoverShoppingCartLinkDisplayed(), "$1,500.00");
		//a[text()='Build your own computer']/parent::div/following-sibling::div[text()='Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]' and text()='RAM: 8GB [+$60.00]' and text()='HDD: 400 GB [+$100.00]'  and text()='OS: Vista Premium [+$60.00]' and text()='Software: Microsoft Office [+$50.00]' and text()='Software: Acrobat Reader [+$10.00]' and text()='Software: Total Commander [+$5.00]']
		
	}

	@Test
	public void TC_03_Edit_Product_In_Shopping_Cart() {

	}

	@Test
	public void TC_04_Remove_From_Cart() {

	}

	@Test
	public void TC_05_Update_Shopping_Cart() {

	}

	@Test
	public void TC_06_CheckOut_Order_Payment_Method_By_Cheque() {

	}

	@Test
	public void TC_07_CheckOut_Order_Payment_Method_By_Card() {

	}

	@Test
	public void TC_08_Re_Order() {

	}
}
