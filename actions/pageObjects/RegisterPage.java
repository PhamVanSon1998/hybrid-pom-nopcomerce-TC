package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPage extends AbtractPage{
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String verifyFirstNameError() {
		waitToElementVisible(driver, RegisterPageUI.FIRST_ERROR);
		return getElementText(driver, RegisterPageUI.FIRST_ERROR);
	}

	public String verifyLastNameError() {
		waitToElementVisible(driver, RegisterPageUI.LASTNAME_ERROR);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR);
	}

	public String verifyEmailError() {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}

	public boolean verifyPasswordError(String passwordError ) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR).contains(passwordError);
	}

	public String verifyConfirmPasswordError() {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR);
	}

	public void clickGenderMaleCheckbox() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_CHECKBOX);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_CHECKBOX);
	}
	
	public void inputToFirstNameTextbox(String firstNameTextbox) {
		waitToElementVisible(driver, RegisterPageUI.FIRTNAME_TEXTBOX);
		senKeysToElement(driver, RegisterPageUI.FIRTNAME_TEXTBOX, firstNameTextbox);
	}

	public void inputToLastNameTextbox(String lastNameTextbox) {
		waitToElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		senKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameTextbox);
	}

	public void selectDayDropdown(String dayDropdown) {
		waitToElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, dayDropdown);
	}

	public void selectMonthDropdown(String monthDropdown) {
		waitToElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, monthDropdown);
	}

	public void selectYearDropdown(String yearDropdown) {
		waitToElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, yearDropdown);
	}

	public void inputToEmailTextbox(String emailTextbox) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailTextbox);
	}

	public void inputToCompanyNameTextbox(String companyNameTextbox) {
		waitToElementVisible(driver, RegisterPageUI.COMPANYNAME_TEXTBOX);
		senKeysToElement(driver, RegisterPageUI.COMPANYNAME_TEXTBOX, companyNameTextbox);
	}

	public void inputToPasswordTextbox(String passwordTextbox) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passwordTextbox);
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordTextbox) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordTextbox);
	}

	public boolean verifyRegisterSuccess(String registerSuccessText) {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		String elementText = getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return elementText.equals(registerSuccessText);
	}

	public HomePage clickLogoutLink() {
		waitToElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		return PageGeneratorManage.getHomePageOject(driver);
	}

	public boolean verifyEmailExist(String emailExist) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_EXIST_TEXT);
		String elementText = getElementText(driver, RegisterPageUI.EMAIL_EXIST_TEXT);
		return elementText.equals(emailExist);
	}

	public void refeshCurrentRegisterPage() {
		refeshCurrentPage(driver);
	}
	public String getRegisterMessageSuccess() {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
		return getElementText(driver, RegisterPageUI.REGISTER_MESSAGE_SUCCESS);
	}
}
