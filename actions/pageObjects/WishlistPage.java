package pageObjects;

import org.openqa.selenium.WebDriver;

import com.nopcomerce.users.MyAccount;

import commons.AbtractPage;
import pageUIs.AddressPageUI;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import pageUIs.WishlistPageUI;

public class WishlistPage extends AbtractPage {
	WebDriver driver;

	public WishlistPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clicktoYourWishlistURL() {
		waitToElementVisible(driver, WishlistPageUI.WISHLIST_URL);
		clickToElement(driver, WishlistPageUI.WISHLIST_URL);
	}

	public String verifyProductDisplayed() {
		waitToElementVisible(driver, WishlistPageUI.PRODUCT_NAME);
		return getElementText(driver, WishlistPageUI.PRODUCT_NAME);
	}

	public void checkToAddToCartCheckbox() {
		waitToElementVisible(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
		checkToCheckBox(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}

	public void clickAddToCartButton() {
		waitToElementVisible(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
	}

	public ShoppingCartPage clickShoppingCartLink() {
		waitToElementVisible(driver, WishlistPageUI.SHOPPING_CART_LINKDS);
		clickToElement(driver, WishlistPageUI.SHOPPING_CART_LINKDS);
		return PageGeneratorManage.getShoppingCartPageOject(driver);
	}


	public void clickToRemoveButton() {
		waitToElementClickable(driver, WishlistPageUI.REMOVE_BUTTON);
		clickToElement(driver,WishlistPageUI.REMOVE_BUTTON);
	}
}
