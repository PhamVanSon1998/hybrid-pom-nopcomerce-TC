package com.nopcomerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbtractTest;
import pageObjects.AddressPage;
import pageObjects.ChangePasswordPage;
import pageObjects.CustomerInforPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyProductReviewPage;

public class MyAccount extends AbtractTest {
	WebDriver driver;
	CustomerInforPage customerInforPageObject;
	HomePage homePageObject;
	LoginPage loginPageObject;
	AddressPage addressPageObject;
	ChangePasswordPage changePasswordPageObject;
	MyProductReviewPage myProductReviewPageObject;

	@Parameters({ "browser", "url", "emailLogin" })
	@BeforeClass
	public void BeforeClass(String browserName, String urlValues, String emailLogin) {
		driver = getBrowserDriver(browserName, urlValues,emailLogin);
	}
	
	@Test
	public void TC_01_Login_Success() {
		log.info("Login Success-Step 01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Login Success-Step 02: Click Login link and navigate to Login Page ");
		loginPageObject = homePageObject.clickLoginLink();
		
		log.info("Login Success-Step 03: Input to Email Textbox" + email);
		loginPageObject.inputToEmailTextbox(email);
		
		log.info("Login Success-Step 04: Input to Password Textbox"+password);
		loginPageObject.inputToPassword(password);
		
		log.info("Login Success-Step 05: Click Login Button");
		homePageObject= loginPageObject.clickToLoginButton();
		
		log.info("Login Success-Step 06: Verify MyAcount link Displayed");
		verifyTrue(loginPageObject.verifyMyaccountLinkDisplay());
	}
	
	@Test
	public void TC_02_Verify_Customer_Infor() {
		log.info("Verify Customer Infor-Step 01: Init Home Page");
		homePageObject = pageObjects.PageGeneratorManage.getHomePageOject(driver);
		
		log.info("Verify Customer Infor-Step 02: Click Myacount link and navigate to CustomerInfor Page");
		customerInforPageObject = homePageObject.clickToMyAccountLink();
		
		log.info("Verify Customer Infor-Step 03: Verify Gender male checkbox");
		verifyTrue(customerInforPageObject.verifyGenderMaleCheckbox());
		
		log.info("Verify Customer Infor-Step 04: Verify FirstName Textbox");
		verifyTrue(customerInforPageObject.verifyFirstNameTextbox(firstName));
		
		log.info("Verify Customer Infor-Step 05: Verify LastName Textbox");
		verifyTrue(customerInforPageObject.verifyLastNameTextbox(lastName));
		
		log.info("Verify Customer Infor-Step 06: Verify date Dropdow");
		verifyTrue(customerInforPageObject.verifyDayDropdown(day));
		
		log.info("Verify Customer Infor-Step 07: Verify month Dropdown");
		verifyTrue(customerInforPageObject.verifyMonthDropdown(month));
		
		log.info("Verify Customer Infor-Step 08: Verify year Dropdown");
		verifyTrue(customerInforPageObject.verifyYearDropdown(year));
		
		log.info("Verify Customer Infor-Step 09: Verify Email Textbox");
		verifyTrue(customerInforPageObject.verifyEmailTextbox(email));
		
		log.info("Verify Customer Infor-Step 10: Verify Company Name Textbox");
		verifyTrue(customerInforPageObject.verifyCompanyNameTextbox(companyName));
	}
	
	@Test
	public void TC_03_Add_Address() {
		log.info("Add Address-Step 01: Init CustomerInfor Page");
		customerInforPageObject =pageObjects.PageGeneratorManage.getCustomerInforPage(driver);
		
		log.info("Add Address-Step 02: Click to Address link and navigate to Address Page");
		addressPageObject = customerInforPageObject.clickToAddressLink();
		
		log.info("Add Address-Step 03: Click to AddNew Button");
		addressPageObject.clickToAddNewButton();
		
		log.info("Add Address-Step 04: Input to AddressFirstName Textbox");
		addressPageObject.inputToAddressFirstNameTextbox(firstName);
		
		log.info("Add Address-Step 05: Input to AddressLastName Textbox");
		addressPageObject.inputToAddressLastNameTextbox(lastName);
		
		log.info("Add Address-Step 06: Input to AddressEmail Textbox");
		addressPageObject.inputToAddressEmailTextbox(email);
		
		log.info("Add Address-Step 07: Input to Address Company Textbox");
		addressPageObject.inputToAddressCompanyTextbox(companyName);
		
		log.info("Add Address-Step 08: Input to Address Country Dropdown");
		addressPageObject.inputToAddressCountryDropdown(country);
		
		log.info("Add Address-Step 09: Input Address State Dropdown");
		addressPageObject.inputToAddressStateDropdown(state);
		
		log.info("Add Address-Step 10: Input to Address City Textbox");
		addressPageObject.inputToAddressCityTextbox(city);
		
		log.info("Add Address-Step 11: Input to Address1 Textbox");
		addressPageObject.inputToAddress1Textbox(address1);
		
		log.info("Add Address-Step 12: Input to Address2 Textbox");
		addressPageObject.inputToAddress2Textbox(address2);
		
		log.info("Add Address-Step 13: Input to Zipcode Textbox");
		addressPageObject.inputToZipCodeTextbox(zipcode);
		
		log.info("Add Address-Step 14: Input to Phone Number Textbox");
		addressPageObject.inputToPhoneNumberTextbox(phoneNumber);
		
		log.info("Add Address-Step 15: Input to FaxNumber Textbox");
		addressPageObject.inputToFaxNumberTextbox(faxNumber);
		
		log.info("Add Address-Step 16: Click Save Button");
		addressPageObject.clickToSaveButton();
		
		log.info("Add Address-Step 17: Verify Infor Table Displayed");
		verifyTrue(addressPageObject.isInforTableDisplaysed());;
	}
	
	@Test
	public void TC_04_Change_Password() {
		log.info("Change Password-Step 01: Init Home Page");
		customerInforPageObject =pageObjects.PageGeneratorManage.getCustomerInforPage(driver);
		
		log.info("Change Password-Step 02: Click to Change Password link and navigate to Change Password Page");
		changePasswordPageObject = customerInforPageObject.clickToChangePasswordLink();
		
		log.info("Change Password-Step 03: Input to OldPassword"+password);
		changePasswordPageObject.inputToOldPasswordTextbox(password);
		
		log.info("Change Password-Step 04: Input to New Password duplicate Old Password"+password);
		changePasswordPageObject.inputToNewPasswordTextbox(password);
		
		log.info("Change Password-Step 05: Input to Confirm Password");
		changePasswordPageObject.inputToConfirmPasswordTextbox(password);
		
		log.info("Change Password-Step 06: Click to Change Password Button");
		changePasswordPageObject.clickToChangePasswordButton();
		
		log.info("Change Password-Step 07: Verify Change Password Mesage error");
		verifyEquals(changePasswordPageObject.verifyChangePasswordMessageError(),"You entered the password that is the same as one of the last passwords you used. Please create a new password.");
		
		
		log.info("Change Password-Step 08: Input to OldPassword"+password);
		changePasswordPageObject.inputToOldPasswordTextbox(password);
		
		log.info("Change Password-Step 09: Input to New Password"+newpassword);
		changePasswordPageObject.inputToNewPasswordTextbox(newpassword);
		
		log.info("Change Password-Step 10: Input to Confirm Password");
		changePasswordPageObject.inputToConfirmPasswordTextbox(newpassword);
		
		log.info("Change Password-Step 11: Click to Change Password Button");
		changePasswordPageObject.clickToChangePasswordButton();
		
		log.info("Change Password-Step 12: Verify Change Password Success");
		verifyTrue(changePasswordPageObject.verifyChangePasswordSuccess());
	}
	
	@Test
	public void TC_05_My_Product_Review() {
		log.info("MyProduct review-Step 01: Init Change Password Page");
		changePasswordPageObject=pageObjects.PageGeneratorManage.getChangePasswordPageOject(driver);
		
		log.info("MyProduct review-Step 02: Click to MyProduct Review link and navigate to MyProduct Review Page");
		myProductReviewPageObject = changePasswordPageObject.clickToMyProductReviewLink();
		
		log.info("MyProduct review-Step 03: Move to Computer link");
		myProductReviewPageObject.moveToComputerLink();
		
		log.info("MyProduct review-Step 04: Click Destop link");
		myProductReviewPageObject.clickToDestopLink();
		
		log.info("MyProduct review-Step 05: Click to Product Review");
		myProductReviewPageObject.clickToProductReview("Build your own computer");
		
		log.info("MyProduct review-Step 06: Click to Add YourReview link");
		myProductReviewPageObject.clickToAddYourReviewLink();
		
		log.info("MyProduct review-Step 07: Input to Review Title Textbox");
		myProductReviewPageObject.inputToReviewTitleTextbox("Product in techinical");
		
		log.info("MyProduct review-Step 08: Input to Reviewtext TextArea");
		myProductReviewPageObject.inputToReviewTextTextArea("good quality");
		
		log.info("MyProduct review-Step 09: Select Rating Checkbox");
		myProductReviewPageObject.selectRatingCheckbox();
		
		log.info("MyProduct review-Step 10: Click Submit Review");
		myProductReviewPageObject.clickToSubmitReview();
		
		log.info("MyProduct review-Step 11: Click to MyAcount link in footer");
		myProductReviewPageObject.clickToMyAcountLinkInFooter("My account");
		
		log.info("MyProduct review-Step 12: Click to My ProductReview link");
		myProductReviewPageObject.clickToMyProductReviewLink1();
		
		
		log.info("MyProduct review-Step 13: Verify Product reviewTitle Displayed");
		verifyTrue(myProductReviewPageObject.isProductReviewTitleDisplayed("Product in techinical"));
		
		log.info("MyProduct review-Step 14: Verify Product reviewText Displayed");
		verifyTrue(myProductReviewPageObject.isProductReviewTextDisplayed("good quality"));
		
		log.info("MyProduct review-Step 15: Verify Product Review Displayed");
		verifyTrue(myProductReviewPageObject.isProductReviewDisplayed("Build your own computer"));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
