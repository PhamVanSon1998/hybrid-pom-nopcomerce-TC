package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Login extends AbtractTest {
	WebDriver driver;
	HomePage homePageObject;
	LoginPage loginPageOject;

	@Parameters({ "browser", "url", "emailLogin" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues, String emailLogin) {
		driver = getBrowserDriver(browserName, urlValues, emailLogin);
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {
		log.info("Login With Empty Data 01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);

		log.info("Login With Empty Data 02: Click to Login link and navigate to Login Page");
		loginPageOject = homePageObject.clickLoginLink();

		log.info("Login With Empty Data 03: Click to Login Button");
		loginPageOject.clickToLoginButton();

		log.info("Login With Empty Data 04: Verify Email Message error");
		verifyEquals(loginPageOject.verifyEmailMessageError(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {
		log.info("Login With Invalid Email 01: Input to Email error Textbox" + emailError);
		loginPageOject.inputToEmailTextbox(emailError);

		log.info("Login With Invalid Email 02: Click to Login Button");
		loginPageOject.clickToLoginButton();

		log.info("Login With Invalid Email 03: Verify Email Massage error");
		verifyEquals(loginPageOject.verifyEmailMessageError(), "Wrong email");
	}

	@Test
	public void TC_03_Login_With_Email_Not_Register() {
		log.info("Login With Email not Register 01: Input to Email Textbox not Register" + emailNotRegister);
		loginPageOject.inputToEmailTextbox(emailNotRegister);

		log.info("Login With Email not Register 02: Click to Login Button");
		loginPageOject.clickToLoginButton();

		log.info("Login With Email not Register 03: Verify Email not Register Message");
		verifyTrue(loginPageOject.verifyEmailNotRegisterMessage("Login was unsuccessful. Please correct the errors and try again."));
	}

	@Test
	public void TC_04_Login_With_Password_Empty() {
		log.info("Login With Password empty 01: Input to Email Textbox " + email);
		loginPageOject.inputToEmailTextbox(email);

		log.info("Login With Password empty 02: Click to Login Button");
		loginPageOject.clickToLoginButton();

		log.info("Login With Password empty 03: Verify Email not Register Message");
		verifyTrue(loginPageOject.verifyEmailNotRegisterMessage( "The credentials provided are incorrect"));
	}

	@Test
	public void TC_05_Login_With_Password_Error() {
		log.info("Login With Password error 01: Input to Email Textbox " + email);
		loginPageOject.inputToEmailTextbox(email);

		log.info("Login With Password empty 02: Input to Password error" + passwordError);
		loginPageOject.inputToPassword(passwordError);

		log.info("Login With Password empty 03: Click to Login Button");
		loginPageOject.clickToLoginButton();

		log.info("Login With Password empty 04: Verify Email not Reister Massage" + email);
		verifyTrue(loginPageOject.verifyEmailNotRegisterMessage( "The credentials provided are incorrect"));
	}

	@Test
	public void TC_06_Login_Success() {
		log.info("Login Success 01: Input to Email Textbox " + email);
		loginPageOject.inputToEmailTextbox(email);
		
		log.info("Login Success 02: Input to newPassword Textbox " + newpassword);
		loginPageOject.inputToPassword(newpassword);
		
		log.info("Login Success 03: Click to Login Button and navigate to Home Page" );
		homePageObject = loginPageOject.clickToLoginButton();
		
		log.info("Login Success 04: Verify My Acount link Displayed");
		verifyTrue(loginPageOject.verifyMyaccountLinkDisplay());
	}

	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
