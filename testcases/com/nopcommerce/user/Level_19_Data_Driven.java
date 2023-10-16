package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_02_Register_New_Account_Cookie;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;

public class Level_19_Data_Driven extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserCustomerInfoPageObject userCustomerInfo;
	private UserDataMapper userData;
	private String firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, randEmail, companyName, gender;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userData = UserDataMapper.getUserData();
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		gender = userData.getUpdateGender();
		firstName = userData.getUpdateFirstName();
		lastName = userData.getUpdatelastName();
		dateOfBirth = userData.getUpdateDateOfBirth();
		monthOfBirth = userData.getUpdateMonthOfBirth();
		yearOfBirth = userData.getUpdateYearOfBirth();
		randEmail = userData.getUpdateEmail() + randomNumber() + "@gmail.net";
		companyName = userData.getUpdateCompanyName();

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
