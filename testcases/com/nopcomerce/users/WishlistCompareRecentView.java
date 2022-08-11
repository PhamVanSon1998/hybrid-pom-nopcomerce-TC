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

		log.info("Add to Wishlist Step-03: Verify Message Displayed: The product has been added to your wishlist");
		verifyEquals(homePageObject.verifyMessageDisplayed(), "The product has been added to your wishlist");

		log.info("Add to Wishlist Step-04: click Close Message Add To Wishlist Success ");
		homePageObject.clickCloseMessageAddToSuccess();

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
		log.info("Add Product to cart from Wishlist Page Step-01: Check to Add to Cart Checkbox");
		wishlistPageObject.checkToAddToCartCheckbox();
		
		log.info("Add Product to cart from Wishlist Page Step-02: Click Add to Cart Button");
		wishlistPageObject.clickAddToCartButton();
		
		log.info("Add Product to cart from Wishlist Page Step-03: Click to Shopping link and navigate to Shopping Cart Page");
		shoppingCartPageObject = wishlistPageObject.clickShoppingCartLink();
		
		log.info("Add Product to cart from Wishlist Page Step-04: Verify Add to cart Success");
		verifyEquals(shoppingCartPageObject.verifyAddToCartSuccess(), "Apple MacBook Pro 13-inch");
		
		log.info("Add Product to cart from Wishlist Page Step-05: Verify Account Wishlist");
		verifyEquals(shoppingCartPageObject.verifyAccountWishlist(), "(2)");

	}

	@Test
	public void TC_04_Remove_Product_In_Wishlist_Page() {
		log.info("Remove Product in Wishlist Page Step-01:Init Home Page");
		homePageObject =PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Remove Product in Wishlist Page Step-02: Move to Computer link");
		homePageObject.moveToComputersLink();
		
		log.info("Remove Product in Wishlist Page Step-03:Click to Noterbooks link");
		homePageObject.clickToNoterbooksLink();
		
		log.info("Remove Product in Wishlist Page Step-04: Click to Product name: Apple MacBook Pro 13-inch");
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");

		log.info("Remove Product in Wishlist Page Step-05: Click to Add to Wishlist");
		homePageObject.clicktoAddToWishlist();

		log.info("Remove Product in Wishlist Page Step-06: Verify Message Displayed: The product has been added to your wishlist");
		verifyEquals(homePageObject.verifyMessageDisplayed(), "The product has been added to your wishlist");

		log.info("Remove Product in Wishlist Page Step-07: click Close Message Add To Wishlist Success ");
		homePageObject.clickCloseMessageAddToSuccess();

		log.info("Remove Product in Wishlist Page Step-08: Click to Wishlist link and navigate to Wishlist Page ");
		wishlistPageObject = homePageObject.clickToWishlistLink();

		log.info("Remove Product in Wishlist Page Step-09: Click to Remove Button");
		wishlistPageObject.clickToRemoveButton();
		
		log.info("Remove Product in Wishlist Page Step-10: Verify Message Wishlist Empty Displayed ");
		verifyEquals(homePageObject.verifyMessageWishlistEmptyDisplayed(), "The wishlist is empty!");
	}

	@Test
	public void TC_05_Add_Product_To_Compare() {
		log.info("Add Product to Compare Step-01:Init Home Page");
		homePageObject =PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Add Product to Compare Step-02: Move to Computer link");
		homePageObject.moveToComputersLink();
		
		log.info("Add Product to Compare Step-03: Click to Noterbooks link");
		homePageObject.clickToNoterbooksLink();
		
		log.info("Add Product to Compare Step-04: Click to Product name:Apple MacBook Pro 13-inch");
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");
		
		log.info("Add Product to Compare Step-05:Click to Add to Compare list");
		homePageObject.clicktoAddToComparelist();
		
		log.info("Add Product to Compare Step-06:Verify Message Add to Compare list Success");
		verifyEquals(homePageObject.isMessageAddToSuccess(),"product comparison");
		
		log.info("Add Product to Compare Step-07:Back to Page");
		homePageObject.backToPage(driver);
		
		log.info("Add Product to Compare Step-08:Click to Product name:Lenovo Thinkpad X1 Carbon Laptop");
		homePageObject.clicktoProductName("Lenovo Thinkpad X1 Carbon Laptop");
		
		log.info("Add Product to Compare Step-09:Click to Add to Compare list");
		homePageObject.clicktoAddToComparelist();
		
		log.info("Add Product to Compare Step-10:Verify Message Add to Compare list Success");
		verifyEquals(homePageObject.isMessageAddToSuccess(),"product comparison");
		
		log.info("Add Product to Compare Step-11:Click to Compare Product list link");
		compareProductsListPageObject = homePageObject.clickCompareProductListLink("Compare products list");
		
		log.info("Add Product to Compare Step-12:Verify amount Product add to compare = 2");
		verifyEquals(compareProductsListPageObject.areSizeProductAddToCompareList(),2);
		
		log.info("Add Product to Compare Step-13:Verify Product Add to Compare list Displayed");
		verifyTrue(compareProductsListPageObject.areProductAddToCompareListDisplayed("Apple MacBook Pro 13-inch","Lenovo Thinkpad X1 Carbon Laptop"));
		
		log.info("Add Product to Compare Step-14:Click Clear list Button");
		compareProductsListPageObject.clickClearListButton();
		
		log.info("Add Product to Compare Step-15:Verify Message Compare list no data");
		verifyEquals(compareProductsListPageObject.isMessageCompareListNoData(),"You have no items to compare.");
	}
	
	@Test
	public void TC_06_Recently_Viewed_Product() {
		log.info("Recently View Product Step-01:Init Home Page");
		homePageObject =PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Recently View Product Step-02:Move to Computer link");
		homePageObject.moveToComputersLink();
		
		log.info("Recently View Product Step-03:Click to Noterbooks link");
		homePageObject.clickToNoterbooksLink();
		
		log.info("Recently View Product Step-04:Click to Product name: Apple MacBook Pro 13-inch");
		homePageObject.clicktoProductName("Apple MacBook Pro 13-inch");
		
		log.info("Recently View Product Step-05: Back to Page");
		homePageObject.backToPage(driver);
		
		log.info("Recently View Product Step-06:Click to Product name: Asus N551JK-XO076H Laptop");
		homePageObject.clicktoProductName("Asus N551JK-XO076H Laptop");
		
		log.info("Recently View Product Step-07:Back to Page");
		homePageObject.backToPage(driver);
		
		log.info("Recently View Product Step-08:Click to Product name: HP Envy 6-1180ca 15.6-Inch Sleekbook");
		homePageObject.clicktoProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook");
		
		log.info("Recently View Product Step-09:Back to Page");
		homePageObject.backToPage(driver);
		
		log.info("Recently View Product Step-10:Click to Product name: HP Spectre XT Pro UltraBook");
		homePageObject.clicktoProductName("HP Spectre XT Pro UltraBook");
		
		log.info("Recently View Product Step-11:Back to Page");
		homePageObject.backToPage(driver);
		
		log.info("Recently View Product Step-12:Click to Product name: Lenovo Thinkpad X1 Carbon Laptop");
		homePageObject.clicktoProductName("Lenovo Thinkpad X1 Carbon Laptop");
		
		log.info("Recently View Product Step-13:Back to Page");
		homePageObject.backToPage(driver);
		
		log.info("Recently View Product Step-01:Verify Recently Product View");
		verifyTrue(homePageObject.areRecentlyProductView("HP Envy 6-1180ca 15.6-Inch Sleekbook","HP Spectre XT Pro UltraBook","Lenovo Thinkpad X1 Carbon Laptop"));
		
	}
}
