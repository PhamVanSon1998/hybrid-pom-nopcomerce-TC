package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPage extends AbtractPage {

	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyAddToCartSuccess() {
		waitToElementVisible(driver, ShoppingCartPageUI.PRODUCT_NAME);
		return getElementText(driver,ShoppingCartPageUI.PRODUCT_NAME);
	}

	public String verifyAccountWishlist() {
		waitToElementVisible(driver, ShoppingCartPageUI.ACCOUNT_WISHLISH);
		return getElementText(driver,ShoppingCartPageUI.ACCOUNT_WISHLISH);
	}

	public void moveToComputersLink() {
		waitToElementVisible(driver, ShoppingCartPageUI.COMPUTER_LINK);
		hoverMouseToElement(driver, ShoppingCartPageUI.COMPUTER_LINK);
		
	}

	public HomePage clickToNoterbooksLink() {
		waitToElementClickable(driver, ShoppingCartPageUI.NOTERBOOK_LINK);
		clickToElement(driver, ShoppingCartPageUI.NOTERBOOK_LINK);
		return PageGeneratorManage.getHomePageOject(driver);
	}

}
