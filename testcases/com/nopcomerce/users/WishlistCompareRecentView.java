package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjects.CompareProductsListPage;
import pageObjects.HomePage;
import pageUIs.HomePageUI;
import pageObjects.LoginPage;
import pageObjects.PageGeneratorManage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import pageObjects.WishlistPage;

public class WishlistCompareRecentView extends AbtractTest {

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
	public void TC_01_Login_Success() {
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
	public void TC_02_Add_To_Wishlist() {
		log.info("Add to Wishlist Step-01: Click to product name: Apple MacBook Pro 13-inch");
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");

		log.info("Add to Wishlist Step-02: Click to Add to Wishlist");
		homePageObject.clicktoAddToWishlist();

//		log.info("Add to Wishlist Step-03: Check to Processor Dropdown");
//		homePageObject.checktoProcessorDropdown();
//		
//		log.info("Add to Wishlist Step-04: Check to Ram Dropdown");
//		homePageObject.checktoRamDropdown();
//		
//		log.info("Add to Wishlist Step-05: Check to HDD RadioButton");
//		homePageObject.checktoHDDRadioButton();
//		
//		log.info("Add to Wishlist Step-05: Check to OS RadioButton");
//		
//		log.info("Add to Wishlist Step-05: Check to Software Checkbox");

		log.info("Add to Wishlist Step-03: Verify Message Displayed: The product has been added to your wishlist");
		verifyEquals(homePageObject.verifyMessageDisplayed(), "The product has been added to your wishlist");

		log.info("Add to Wishlist Step-04: click Close Message Add To Wishlist Success ");
		homePageObject.clickCloseMessageAddToWishlistSuccess();

		log.info("Add to Wishlist Step-05: Click to Wishlist link and navigate to Wishlist Page ");
		wishlistPageObject = homePageObject.clickToWishlistLink();

		log.info("Add to Wishlist Step-06: Verify Product Displayed: ");
		verifyEquals(wishlistPageObject.verifyProductDisplayed(), "Apple MacBook Pro 13-inch");

		log.info("Add to Wishlist Step-07: Click to Your wishlist URL for sharing: ");
		wishlistPageObject.clicktoYourWishlistURL();

		log.info("Add to Wishlist Step-08: Verify Product Displayed: ");
		verifyEquals(wishlistPageObject.verifyProductDisplayed(), "Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_03_Add_Product_To_Cart_From_Wishlist_Page() {
		wishlistPageObject.checkToAddToCartCheckbox();
		wishlistPageObject.clickAddToCartButton();
		shoppingCartPageObject = wishlistPageObject.clickShoppingCartLink();
		verifyEquals(shoppingCartPageObject.verifyAddToCartSuccess(), "Apple MacBook Pro 13-inch");
		verifyEquals(shoppingCartPageObject.verifyAccountWishlist(), "(2)");

	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		shoppingCartPageObject.moveToComputersLink();
		homePageObject = shoppingCartPageObject.clickToNoterbooksLink();
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");

		log.info("Add to Wishlist Step-02: Click to Add to Wishlist");
		homePageObject.clicktoAddToWishlist();

		log.info("Add to Wishlist Step-03: Verify Message Displayed: The product has been added to your wishlist");
		verifyEquals(homePageObject.verifyMessageDisplayed(), "The product has been added to your wishlist");

		log.info("Add to Wishlist Step-04: click Close Message Add To Wishlist Success ");
		homePageObject.clickCloseMessageAddToWishlistSuccess();

		log.info("Add to Wishlist Step-05: Click to Wishlist link and navigate to Wishlist Page ");
		wishlistPageObject = homePageObject.clickToWishlistLink();

		wishlistPageObject.clickToRemoveButton();
		verifyEquals(homePageObject.verifyMessageWishlistEmptyDisplayed(), "The wishlist is empty!");
	}

	@Test
	public void TC_05_Add_Product_To_Compare() {
		shoppingCartPageObject = wishlistPageObject.clickShoppingCartLink();
		shoppingCartPageObject.moveToComputersLink();
		homePageObject = shoppingCartPageObject.clickToNoterbooksLink();
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");
		homePageObject.clicktoAddToComparelist();
		verifyEquals(homePageObject.verifyMessageAddToCompareListSuccess(),"product comparison");
		homePageObject.backToPage(driver);
		homePageObject.clicktoProductName("Lenovo Thinkpad X1 Carbon Laptop");
		homePageObject.clicktoAddToComparelist();
		verifyEquals(homePageObject.verifyMessageAddToCompareListSuccess(),"product comparison");
		compareProductsListPageObject = homePageObject.clickCompareProductListLink("Compare products list");
		verifyEquals(compareProductsListPageObject.areSizeProductAddToCompareList(),2);
		verifyTrue(compareProductsListPageObject.areProductAddToCompareListDisplayed("Apple MacBook Pro 13-inch","Lenovo Thinkpad X1 Carbon Laptop"));
		compareProductsListPageObject.clickClearListButton();
		verifyEquals(compareProductsListPageObject.isMessageCompareListNoData(),"You have no items to compare.");
	}
	
	@Test
	public void TC_06_Recently_Viewed_Product() {
		homePageObject =PageGeneratorManage.getHomePageOject(driver);
		homePageObject.moveToComputersLink();
		homePageObject.clickToNoterbooksLink();
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");
		homePageObject.backToPage(driver);
		homePageObject.clicktoProductName("Asus N551JK-XO076H Laptop");
		homePageObject.backToPage(driver);
		homePageObject.clicktoProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook");
		homePageObject.backToPage(driver);
		homePageObject.clicktoProductName("HP Spectre XT Pro UltraBook");
		homePageObject.backToPage(driver);
		homePageObject.clicktoProductName("Lenovo Thinkpad X1 Carbon Laptop");
		homePageObject.backToPage(driver);
		verifyTrue(homePageObject.areRecentlyProductView("HP Envy 6-1180ca 15.6-Inch Sleekbook","HP Spectre XT Pro UltraBook","Lenovo Thinkpad X1 Carbon Laptop"));
		
	}
}
