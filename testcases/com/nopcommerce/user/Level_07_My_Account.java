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
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;

public class Level_07_My_Account extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserAddressPageObject userAddress;
	private UserCustomerInfoPageObject userCustomerInfo;
	private String firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, randEmail, companyName, gender;
	private String country, state, city, address1, address2, zipCode, phoneNumber;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		gender = "Male";
		firstName = "Auto";
		lastName = "Tester";
		dateOfBirth = "3";
		monthOfBirth = "March";
		yearOfBirth = "2022";
		randEmail = "AutotestVN" + randomNumber() + "@gmail.net";
		companyName = "Automation Tester Company";

		country = "United States";
		state = "Alaska";
		city = "Ha Noi city";
		address1 = "1/2/3 Me Tri";
		address2 = "3/4/5 Dong Me";
		zipCode = "1234567890";
		phoneNumber = "0123456789";

		userHomePage.openLoginPage();
		userHomePage.setCookie(driver, Common_02_Register_New_Account_Cookie.loggedCookies);
		userHomePage.refreshCurrentPage(driver);
		userHomePage.closeMessageLoginSuccessfully();
		userCustomerInfo = userHomePage.openMyAccountPage();
	}

	@Test
	public void TC_01_Update_Customer_info() {
		log.info("TC_01 - Step 01: Update Gender");
		userCustomerInfo.selectGenderByText(gender);

		log.info("TC_01 - Step 02: Update First name");
		userCustomerInfo.inputToFirstNameTextbox(firstName);

		log.info("TC_01 - Step 03: Update Last name");
		userCustomerInfo.inputToLastNameTextbox(lastName);

		log.info("TC_01 - Step 04: Update Date of birth");
		userCustomerInfo.selectDateOfBirthDropdown(dateOfBirth);

		log.info("TC_01 - Step 05: Update Month of birth");
		userCustomerInfo.selectMonthOfBirthDropdown(monthOfBirth);

		log.info("TC_01 - Step 06: Update Year of birth");
		userCustomerInfo.selectYearOfBirthDropdown(yearOfBirth);

		log.info("TC_01 - Step 07: Update Email");
		userCustomerInfo.inputToEmailTextbox(randEmail);

		log.info("TC_01 - Step 08: Update Company name");
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
		userAddress = userHomePage.openAddressPage(driver);

		log.info("TC_02 - Step 02: Click button 'Add new'");
		userAddress.clickToAddNewButton();

		log.info("TC_02 - Step 03: Input to First name textbox");
		userAddress.inputToFirstNameTextbox(firstName);

		log.info("TC_02 - Step 04: Input to Last name textbox");
		userAddress.inputToLastNameTextbox(lastName);

		log.info("TC_02 - Step 05: Input to Email textbox");
		userAddress.inputToEmailTextbox(randEmail);

		log.info("TC_02 - Step 06: Input to Company textbox");
		userAddress.inputToCompanyTextbox(companyName);

		log.info("TC_02 - Step 07: Select Country");
		userAddress.selectCountryDropdown(country);

		log.info("TC_02 - Step 08: Select State/Province");
		userAddress.selectStateDropdown(state);

		log.info("TC_02 - Step 09: Input to City textbox");
		userAddress.inputToCityTextbox(city);

		log.info("TC_02 - Step 10: Input to Address1 textbox");
		userAddress.inputToAddress1Textbox(address1);

		log.info("TC_02 - Step 11: Input to Address2 textbox");
		userAddress.inputToAddress2Textbox(address2);

		log.info("TC_02 - Step 12: Input to Zipcode textbox");
		userAddress.inputToZipCodeTextbox(zipCode);

		log.info("TC_02 - Step 13: Input to Phone number textbox");
		userAddress.inputToPhoneNumberTextbox(phoneNumber);

		log.info("TC_02 - Step 14: Click to Save button");
		userAddress.clickToSaveButton();

		log.info("TC_02 - Step 15: Verify data inputed");
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

	@Test
	public void TC_03_Change_Password() {

	}

	@Test
	public void TC_04_Add_Reviews() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
