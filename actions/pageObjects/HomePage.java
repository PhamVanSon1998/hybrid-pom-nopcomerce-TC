package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.HomePageUI;
import pageUIs.ShoppingCartPageUI;
import pageUIs.WishlistPageUI;

public class HomePage extends AbtractPage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPage clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return pageObjects.PageGeneratorManage.getRegisterPageOject(driver);
	}

	public LoginPage clickLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManage.getLoginPageOject(driver);
	}

	public CustomerInforPage clickToMyAccountLink() {
		waitToElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManage.getCustomerInforPage(driver);
	}

	public SearchPage clickSearchLink(String footerLinkText) {
		waitToElementClickable(driver, HomePageUI.FOOTER_TEXT_LINK, footerLinkText);
		clickToElement(driver, HomePageUI.FOOTER_TEXT_LINK,footerLinkText);
		return PageGeneratorManage.getSearchPageOject(driver);
	}
	public boolean isRegisterLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

	public boolean isLoginLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGIN_LINK);
	}

	public void clicktoProductName(String ProductName) {
		waitToElementClickable(driver, HomePageUI.PRODUCT_NAME, ProductName);
		clickToElement(driver, HomePageUI.PRODUCT_NAME, ProductName);
	}

	public void clicktoAddToWishlist() {
		waitToElementClickable(driver, HomePageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, HomePageUI.ADD_TO_WISHLIST_BUTTON);
	}

	public String verifyMessageDisplayed() {
		waitToElementVisible(driver, HomePageUI.MESSAGE_WISHLIST_SUCCESS);
		return getElementText(driver, HomePageUI.MESSAGE_WISHLIST_SUCCESS);
	}

	public WishlistPage clickToWishlistLink() {
		waitToElementInVisible(driver, HomePageUI.MESSAGE_WISHLIST_SUCCESS_CLOSE);
		waitToElementClickable(driver, HomePageUI.WISHLIST_LINK);
		clickToElement(driver, HomePageUI.WISHLIST_LINK);
		return PageGeneratorManage.getWishlistPageOject(driver);
	}

	public void clickCloseMessageAddToSuccess() {
		waitToElementClickable(driver, HomePageUI.MESSAGE_WISHLIST_SUCCESS_CLOSE);
		clickToElement(driver, HomePageUI.MESSAGE_WISHLIST_SUCCESS_CLOSE);
	}

	public String verifyMessageWishlistEmptyDisplayed() {
		waitToElementVisible(driver, WishlistPageUI.WISHLIST_MESSAGE_EMPTY);
		return getElementText(driver, WishlistPageUI.WISHLIST_MESSAGE_EMPTY);
	}

	public void clicktoAddToComparelist() {
		waitToElementClickable(driver, HomePageUI.ADD_TO_COMPARE_LIST_BUTTON);
		clickToElement(driver, HomePageUI.ADD_TO_COMPARE_LIST_BUTTON);
	}

	public String isMessageAddToSuccess() {
		waitToElementClickable(driver, HomePageUI.MESSAGE_ADD_TO_SUCCESS);
		return getElementText(driver, HomePageUI.MESSAGE_ADD_TO_SUCCESS);
	}

	public CompareProductsListPage clickCompareProductListLink(String footerLinkText) {
		scrollToElement(driver, HomePageUI.FOOTER_TEXT_LINK,footerLinkText);
		waitToElementClickable(driver, HomePageUI.FOOTER_TEXT_LINK,footerLinkText);
		clickToElement(driver, HomePageUI.FOOTER_TEXT_LINK,footerLinkText);
		return PageGeneratorManage.getCompareProductsListPageOject(driver);
	}
	
	public void moveToComputersLink() {
		waitToElementVisible(driver, HomePageUI.COMPUTER_LINK);
		hoverMouseToElement(driver, HomePageUI.COMPUTER_LINK);
	}
	
	public void clickToNoterbooksLink() {
		waitToElementClickable(driver, HomePageUI.NOTERBOOK_LINK);
		clickToElement(driver, HomePageUI.NOTERBOOK_LINK);
	}
	
	public void clickToProductTypeLink(String productType) {
		waitToElementClickable(driver, HomePageUI.PRODUCT_TYPE_LINK,productType);
		clickToElement(driver, HomePageUI.PRODUCT_TYPE_LINK,productType);
	}

	public boolean areRecentlyProductView(String Product1, String Product2, String Product3) {
		waitToElementVisible(driver, HomePageUI.RECENTLY_PRODUCT_VIEW, Product3,Product2,Product1);
		return isElementDisplayed(driver, HomePageUI.RECENTLY_PRODUCT_VIEW, Product3,Product2,Product1);
	}

	public void selectComponetOfCPUDropdown(String componentsOfCPUDropdown,String processorDropdown) {
		waitToElementVisible(driver, HomePageUI.COMPONENTS_OF_CPU_DROPDOWN,componentsOfCPUDropdown);
		selectItemInDropdown(driver, HomePageUI.COMPONENTS_OF_CPU_DROPDOWN,processorDropdown,componentsOfCPUDropdown);
		
	}
	

	public void checkComponetOfCPUCheckbox(String componentsOfCPUDropdown, String processorCheckbox) {
		waitToElementVisible(driver, HomePageUI.COMPONENTS_OF_CPU_CHECKBOX,componentsOfCPUDropdown,processorCheckbox);
		checkToCheckBox(driver, HomePageUI.COMPONENTS_OF_CPU_CHECKBOX,componentsOfCPUDropdown,processorCheckbox);
	}
	

	public void checktoSoftwareRadioButton(String software) {
		waitToElementVisible(driver, HomePageUI.SOFTWARE_RADIOBUTTON,software);
		checkToCheckBox(driver, HomePageUI.SOFTWARE_RADIOBUTTON,software);
	}

	public void inputToQuantityAddToCartTextbox(String quantityAddToCartTextbox) {
		waitToElementVisible(driver, HomePageUI.QUANTITY_ADD_TO_CART_TEXTBOX);
		senKeysToElement(driver, HomePageUI.QUANTITY_ADD_TO_CART_TEXTBOX, quantityAddToCartTextbox);
	}
	
	public void clickAddToCartButton() {
		waitToElementClickable(driver, HomePageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, HomePageUI.ADD_TO_CART_BUTTON);
	}

	public String isQuantityProductInShoppingCart() {
		waitToElementVisible(driver, HomePageUI.QUANTITY_PRODUCT_INSHOPPING_CART);
		return getElementText(driver, HomePageUI.QUANTITY_PRODUCT_INSHOPPING_CART);
	}

	public void moveToShoppingCartLink() {
		waitToElementVisible(driver, HomePageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, HomePageUI.SHOPPING_CART_LINK);
	}

	public String isTextWhenHoverShoppingCartLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.MINI_SHOPPING_CART_TITLE);
		return getElementText(driver, HomePageUI.MINI_SHOPPING_CART_TITLE);
	}

	public boolean isInforProductWhenHoverShoppingCartLinkDisplayed(String productName, String processor,String ram,String hdd,String os,String software1,String software2) {
		waitToElementVisible(driver, HomePageUI.PRODUCT_INFOR, productName,processor,ram,hdd,os,software1,software2);
		return isElementDisplayed(driver, HomePageUI.PRODUCT_INFOR, productName,processor,ram,hdd,os,software1,software2);
	}

	public String isInforSubtotalWhenHoverShoppingCartLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.SUB_TOTAL_PRICE);
		return getElementText(driver, HomePageUI.SUB_TOTAL_PRICE);
	}

}
