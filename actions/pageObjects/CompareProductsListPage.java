package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.CompareProductsListPageUI;

public class CompareProductsListPage extends AbtractPage{
	WebDriver driver;

	public CompareProductsListPage(WebDriver driver) {
		this.driver = driver;
	}

	public int areSizeProductAddToCompareList() {
		waitToElementVisible(driver, CompareProductsListPageUI.COMPARE_PRODUCTS);
		return countElementSize(driver, CompareProductsListPageUI.COMPARE_PRODUCTS);
	}

	public boolean areProductAddToCompareListDisplayed(String product1,String product2) {
		waitToElementVisible(driver, CompareProductsListPageUI.PRODUCTS_NAME,product2,product1);
		return isElementDisplayed(driver, CompareProductsListPageUI.PRODUCTS_NAME,product2,product1);
	}

	public void clickClearListButton() {
		waitToElementClickable(driver, CompareProductsListPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver,CompareProductsListPageUI.CLEAR_LIST_BUTTON);
	}

	public String isMessageCompareListNoData() {
		waitToElementVisible(driver, CompareProductsListPageUI.CLEAR_LIST_MESSAGE);
		return getElementText(driver, CompareProductsListPageUI.CLEAR_LIST_MESSAGE);
	}

}
