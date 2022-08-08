package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractPage;
import commons.AbtractTest;
import java_cup.runtime.virtual_parse_stack;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class Register extends AbtractTest {

	WebDriver driver;
	HomePage homePageOject;
	RegisterPage registerPageOject;

	@Parameters({ "browser", "url", "emailLogin" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues, String emailLogin) {
		driver = getBrowserDriver(browserName, urlValues, emailLogin);
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		log.info("Register With Empty Data-Step 01: Init Home Page");
		homePageOject = pageObjects.PageGeneratorManage.getHomePageOject(driver);

		log.info("Register With Empty Data-Step 02: Verify Register Link Displayed");
		verifyTrue(homePageOject.isRegisterLinkDisplayed());

		log.info("Register With Empty Data-Step 03: Verify Login Link Displayed");
		verifyTrue(homePageOject.isLoginLinkDisplayed());

		log.info("Register With Empty Data-Step 04: Click to Register Link  and Open Register Page");
		registerPageOject = homePageOject.clickToRegisterLink();

		log.info("Register With Empty Data-Step 05: Click to Register Button");
		registerPageOject.clickToRegisterButton();
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("Register With Empty Data-Step 06: Verify FirstName error");
		verifyEquals(registerPageOject.verifyFirstNameError(), "First name is required.");

		log.info("Register With Empty Data-Step 07: Verify LastName error");
		verifyEquals(registerPageOject.verifyLastNameError(), "Last name is required.");

		log.info("Register With Empty Data-Step 08: Verify email error");
		verifyEquals(registerPageOject.verifyEmailError(), "Email is required.");

		log.info("Register With Empty Data-Step 09: Verify password error");
		verifyTrue(registerPageOject.verifyPasswordError( "Password is required."));

		log.info("Register With Empty Data-Step 10: Verify confirm password error");
		verifyEquals(registerPageOject.verifyConfirmPasswordError(), "Password is required.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		log.info("Register With Invalid Email-Step 01: Verify Register link displayed");
		verifyTrue(homePageOject.isRegisterLinkDisplayed());

		log.info("Register With Invalid Email-Step 02: Verify Login link displayed");
		verifyTrue(homePageOject.isLoginLinkDisplayed());

		log.info("Register With Invalid Email-Step 03: Click Gender male Checkbox");
		registerPageOject.clickGenderMaleCheckbox();

		log.info("Register With Invalid Email-Step 04: Input to FirstName Textbox");
		registerPageOject.inputToFirstNameTextbox(firstName);

		log.info("Register With Invalid Email-Step 05: Input to LastName Textbox");
		registerPageOject.inputToLastNameTextbox(lastName);

		log.info("Register With Invalid Email-Step 06: Select date Dropdown");
		registerPageOject.selectDayDropdown(day);

		log.info("Register With Invalid Email-Step 07: Select month Dropdown");
		registerPageOject.selectMonthDropdown(month);

		log.info("Register With Invalid Email-Step 08: Select year Dropdown");
		registerPageOject.selectYearDropdown(year);

		log.info("Register With Invalid Email-Step 09: Input to Email error Textbox" + emailError);
		registerPageOject.inputToEmailTextbox(emailError);

		log.info("Register With Invalid Email-Step 10: Input to Company Name Textbox");
		registerPageOject.inputToCompanyNameTextbox(companyName);

		log.info("Register With Invalid Email-Step 11: Input to Password Textbox" + password);
		registerPageOject.inputToPasswordTextbox(password);

		log.info("Register With Invalid Email-Step 12: Input to Confirm Password");
		registerPageOject.inputToConfirmPasswordTextbox(password);

		log.info("Register With Invalid Email-Step 13: Click to Register Button");
		registerPageOject.clickToRegisterButton();

		log.info("Register With Invalid Email-Step 14: Verify Email error");
		verifyEquals(registerPageOject.verifyEmailError(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Succsess() {
		log.info("Register Succsess-Step 01: Click Gender male Checkbox");
		registerPageOject.clickGenderMaleCheckbox();

		log.info("Register Succsess-Step 02: Input to FirstName Textbox");
		registerPageOject.inputToFirstNameTextbox(firstName);

		log.info("Register Succsess-Step 03: Input to LastName Textbox");
		registerPageOject.inputToLastNameTextbox(lastName);

		log.info("Register Succsess-Step 04: Select date Dropdown");
		registerPageOject.selectDayDropdown(day);

		log.info("Register Succsess-Step 05: Select month Dropdown");
		registerPageOject.selectMonthDropdown(month);

		log.info("Register Succsess-Step 06: Select year Dropdown");
		registerPageOject.selectYearDropdown(year);

		log.info("Register Succsess-Step 07: Input to Email error Textbox" + email);
		registerPageOject.inputToEmailTextbox(email);

		log.info("Register Succsess-Step 08: Input to Company Name Textbox");
		registerPageOject.inputToCompanyNameTextbox(companyName);

		log.info("Register Succsess-Step 09: Input to Password Textbox" + password);
		registerPageOject.inputToPasswordTextbox(password);

		log.info("Register Succsess-Step 10: Input to Confirm Password");
		registerPageOject.inputToConfirmPasswordTextbox(password);

		log.info("Register Succsess-Step 11: Click to Register Button");
		registerPageOject.clickToRegisterButton();

		log.info("Register Succsess-Step 12: Verify Register Success");
		verifyTrue(registerPageOject.verifyRegisterSuccess("Your registration completed"));
	}

	@Test
	public void TC_04_Register_With_Email_existed() {
		log.info("Register With Email existed-Step 01: Click Logout Link and navigate to Home Page");
		homePageOject = registerPageOject.clickLogoutLink();

		log.info("Register With Email existed-Step 02: Open Register Page");
		registerPageOject = homePageOject.clickToRegisterLink();

		log.info("Register With Email existed-Step 03: Click Gender male Checkbox");
		registerPageOject.clickGenderMaleCheckbox();

		log.info("Register With Email existed-Step 04: Input to FirstName Textbox");
		registerPageOject.inputToFirstNameTextbox(firstName);

		log.info("Register With Email existed-Step 05: Input to LastName Textbox");
		registerPageOject.inputToLastNameTextbox(lastName);

		log.info("Register With Email existed-Step 06: Select date Dropdown");
		registerPageOject.selectDayDropdown(day);

		log.info("Register With Email existed-Step 07: Select month Dropdown");
		registerPageOject.selectMonthDropdown(month);

		log.info("Register With Email existed-Step 08: Select year Dropdown");
		registerPageOject.selectYearDropdown(year);

		log.info("Register With Email existed-Step 09: Input to Email error Textbox" + email);
		registerPageOject.inputToEmailTextbox(email);

		log.info("Register With Email existed-Step 10: Input to Company Name Textbox");
		registerPageOject.inputToCompanyNameTextbox(companyName);

		log.info("Register With Email existed-Step 11: Input to Password Textbox" + password);
		registerPageOject.inputToPasswordTextbox(password);

		log.info("Register With Email existed-Step 12: Input to Confirm Password");
		registerPageOject.inputToConfirmPasswordTextbox(password);

		log.info("Register With Email existed-Step 13: Click to Register Button");
		registerPageOject.clickToRegisterButton();

		log.info("Register With Email existed-Step 14: Verify Email Exist");
		verifyTrue(registerPageOject.verifyEmailExist("The specified email already exists"));
	}

	@Test
	public void TC_05_Register_With_Password_Less_06_Character() {
		log.info("Register With Password less 06 Character-Step 01: Input to Password textbox" + passwordLow);
		registerPageOject.inputToPasswordTextbox(passwordLow);

		log.info("Register With Password less 06 Character-Step 02: Input to Confirm Password Textbox" + passwordLow);
		registerPageOject.inputToConfirmPasswordTextbox(passwordLow);

		log.info("Register With Password less 06 Character-Step 03: Click to Register Button");
		registerPageOject.clickToRegisterButton();

		log.info("Register With Password less 06 Character-Step 04: Verify Password less 06 Character");
		verifyTrue(registerPageOject.verifyPasswordError( "must have at least 6 characters"));
	}

	@Test
	public void TC_06_Register_With_Password_And_Confirm_Not_Match() {
		log.info("Register With Password and Confirm Password nt match-Step 01: Input to Password textbox" + password);
		registerPageOject.inputToPasswordTextbox(password);

		log.info("Register With Password and Confirm Password nt match-Step 02: Input to Confirm Password Textbox" + confirmPassword);
		registerPageOject.inputToConfirmPasswordTextbox(confirmPassword);

		log.info("Register With Password and Confirm Password nt match-Step 03: Click to Register Button");
		registerPageOject.clickToRegisterButton();

		log.info("Register With Password and Confirm Password nt match-Step 04: Verify Password and Confirmation Password do not match");
		verifyEquals(registerPageOject.verifyConfirmPasswordError(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
