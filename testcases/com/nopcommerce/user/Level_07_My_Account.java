package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_02_Register_New_Account_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import utilities.DataHelper;

public class Level_07_My_Account extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserAddressPageObject userAddress;
	private UserCustomerInfoPageObject userCustomerInfo;
	private UserChangePasswordPageObject userChangePassword;
	private UserMyProductReviewPageObject userMyProductReview;
	private DataHelper dataFaker;
	private Common_02_Register_New_Account_Cookie commonAccount;
	private String firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, randEmail, companyName, gender;
	private String country, state, city, address1, address2, zipCode, phoneNumber;
	private String oldPassword, newPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		dataFaker = DataHelper.getData();
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		gender = "Male";
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		dateOfBirth = "3";
		monthOfBirth = "March";
		yearOfBirth = "2022";
		randEmail = dataFaker.getEmail();
		companyName = dataFaker.getCompanyName();

		country = "United States";
		state = "Alaska";
		city = dataFaker.getCityName();
		address1 = dataFaker.getFullAddress();
		address2 = dataFaker.getSecondAddress();
		zipCode = dataFaker.getZipcode();
		phoneNumber = dataFaker.getPhoneNumber();

		// oldPassword = commonAccount.getPassword();
		newPassword = dataFaker.getPassword();

		userHomePage.openLoginPage();
		userHomePage.setCookie(driver, Common_02_Register_New_Account_Cookie.loggedCookies);
		userHomePage.refreshCurrentPage(driver);
		userHomePage.closeMessageLoginSuccessfully();
		userCustomerInfo = userHomePage.openMyAccountPage();
	}

	@Test
	public void TC_01_Update_Customer_info() {
		log.info("TC_01 - Step 01: Update Gender to '" + gender + "'");
		userCustomerInfo.selectGenderByText(gender);

		log.info("TC_01 - Step 02: Update First name to '" + firstName + "'");
		userCustomerInfo.inputToFirstNameTextbox(firstName);

		log.info("TC_01 - Step 03: Update Last name to '" + lastName + "'");
		userCustomerInfo.inputToLastNameTextbox(lastName);

		log.info("TC_01 - Step 04: Update Date of birth to '" + dateOfBirth + "'");
		userCustomerInfo.selectDateOfBirthDropdown(dateOfBirth);

		log.info("TC_01 - Step 05: Update Month of birth to '" + monthOfBirth + "'");
		userCustomerInfo.selectMonthOfBirthDropdown(monthOfBirth);

		log.info("TC_01 - Step 06: Update Year of birth to '" + yearOfBirth + "'");
		userCustomerInfo.selectYearOfBirthDropdown(yearOfBirth);

		log.info("TC_01 - Step 07: Update Email to '" + randEmail + "'");
		userCustomerInfo.inputToEmailTextbox(randEmail);

		log.info("TC_01 - Step 08: Update Company name to '" + companyName + "'");
		userCustomerInfo.inputToCompanyNameTextbox(companyName);

		log.info("TC_01 - Step 09: Click button 'Save'");
		userCustomerInfo.clickToSaveButton();

		log.info("TC_01 - Step 10: Verify data updated" + "\n");
		Assert.assertTrue(userCustomerInfo.isUpdateSuccessfullyMessageDisplayed());
		Assert.assertTrue(userCustomerInfo.isGenderSelected(gender));
		Assert.assertEquals(userCustomerInfo.isFirstNameUpdated(), firstName);
		Assert.assertEquals(userCustomerInfo.isLastNameUpdated(), lastName);
		Assert.assertEquals(userCustomerInfo.isDateOfBirthUpdated(), dateOfBirth);
		Assert.assertEquals(userCustomerInfo.isMonthOfBirthUpdated(), monthOfBirth);
		Assert.assertEquals(userCustomerInfo.isYearOfBirthUpdated(), yearOfBirth);
		Assert.assertEquals(userCustomerInfo.isEmailUpdated(), randEmail);
		Assert.assertEquals(userCustomerInfo.isCompanyNameUpdated(), companyName);
	}

	@Test
	public void TC_02_Add_Addresses() {
		log.info("TC_02 - Step 01: Open 'Addresses' page");
		userAddress = userCustomerInfo.openAddressPage(driver);

		log.info("TC_02 - Step 02: Click button 'Add new'");
		userAddress.clickToAddNewButton();

		log.info("TC_02 - Step 03: Input to First name textbox with value is '" + firstName + "'");
		userAddress.inputToFirstNameTextbox(firstName);

		log.info("TC_02 - Step 04: Input to Last name textbox with value is '" + lastName + "'");
		userAddress.inputToLastNameTextbox(lastName);

		log.info("TC_02 - Step 05: Input to Email textbox with value is '" + randEmail + "'");
		userAddress.inputToEmailTextbox(randEmail);

		log.info("TC_02 - Step 06: Input to Company textbox with value is '" + companyName + "'");
		userAddress.inputToCompanyTextbox(companyName);

		log.info("TC_02 - Step 07: Select Country with value is '" + country + "'");
		userAddress.selectCountryDropdown(country);

		log.info("TC_02 - Step 08: Select State/Province with value is '" + state + "'");
		userAddress.selectStateDropdown(state);

		log.info("TC_02 - Step 09: Input to City textbox with value is '" + city + "'");
		userAddress.inputToCityTextbox(city);

		log.info("TC_02 - Step 10: Input to Address1 textbox with value is '" + address1 + "'");
		userAddress.inputToAddress1Textbox(address1);

		log.info("TC_02 - Step 11: Input to Address2 textbox with value is '" + address2 + "'");
		userAddress.inputToAddress2Textbox(address2);

		log.info("TC_02 - Step 12: Input to Zipcode textbox with value is '" + zipCode + "'");
		userAddress.inputToZipCodeTextbox(zipCode);

		log.info("TC_02 - Step 13: Input to Phone number textbox with value is '" + phoneNumber + "'");
		userAddress.inputToPhoneNumberTextbox(phoneNumber);

		log.info("TC_02 - Step 14: Click to Save button");
		userAddress.clickToSaveButton();

		log.info("TC_02 - Step 15: Verify data inputed /n");
		verifyTrue(userAddress.isAddNewAddressSuccessMessageDisplay());
		verifyEquals(userAddress.isFirstNameAndLastNameDisplayed(), firstName + " " + lastName);
		verifyTrue(userAddress.isEmailDisplayed(randEmail));
		verifyEquals(userAddress.isCompanyDisplayed(), companyName);
		verifyEquals(userAddress.isCountrySelected(), country);
		verifyTrue(userAddress.isStateSelected(state));
		verifyTrue(userAddress.isCityDisplayed(city));
		verifyEquals(userAddress.isAddress1Displayed(), address1);
		verifyEquals(userAddress.isAddress2Displayed(), address2);
		verifyTrue(userAddress.isZipCodeDisplayed(zipCode));
		verifyTrue(userAddress.isPhoneNumberDisplayed(phoneNumber));
	}

	// @Test
	public void TC_03_Change_Password() {
		log.info("TC_03 - Step 01: Open 'Change Password' page");
		userChangePassword = userAddress.openChangePasswordPage(driver);

		log.info("TC_03 - Step 02: input to Old Password textbox with value '" + oldPassword + "'");
		userChangePassword.inputToOldPasswordTextbox(oldPassword);

		log.info("TC_03 - Step 03: input to New Password textbox with value '" + newPassword + "'");
		userChangePassword.inputToNewPasswordTextbox(newPassword);

		log.info("TC_03 - Step 04: input to Confirm New Password textbox with value '" + newPassword + "'");
		userChangePassword.inputToConfirmPasswordTextbox(newPassword);

		log.info("TC_03 - Step 05: Click to Change Password button");
		userChangePassword.clickToChangePasswordButton();

		log.info("TC_03 - Step 06: Verify update Password successfully");
		verifyTrue(userChangePassword.isChangePasswordSuccessMessageDisplayed());
	}

	@Test
	public void TC_04_Add_Reviews() {
		log.info("TC_03 - Step 01: Open 'My Product Review' page");
		userMyProductReview = userAddress.openMyProductReviewPage(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
