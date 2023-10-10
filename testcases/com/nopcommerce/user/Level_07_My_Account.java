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
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;

public class Level_07_My_Account extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserCustomerInfoPageObject userCustomerInfo;
	private String firstName, lastName, dateOfBirth, monthOfBirth, yearOfBirth, randEmail, companyName;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Auto";
		lastName = "Tester";
		dateOfBirth = "3";
		monthOfBirth = "March";
		yearOfBirth = "2022";
		randEmail = "AutotestVN" + randomNumber() + "@gmail.net";
		companyName = "Automation Tester Company";

		userHomePage.openLoginPage();
		userHomePage.setCookie(driver, Common_02_Register_New_Account_Cookie.loggedCookies);
		userHomePage.refreshCurrentPage(driver);
		userHomePage.closeMessageLoginSuccessfully();
		userCustomerInfo = userHomePage.openMyAccountPage();
	}

	@Test
	public void TC_01_Update_Customer_info() {
		log.info("TC_01 - Step 01: Update Gender");
		userCustomerInfo.selectGenderByText("Male");

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

		log.info("TC_01 - Step 09: Update Company name");
		userCustomerInfo.clickToSaveButton();
		sleepInSecond(5);

		userCustomerInfo.closeUpdateSuccessMessage();

		Assert.assertTrue(userCustomerInfo.isUpdateSuccessfullyMessageDisplayed());
		Assert.assertTrue(userCustomerInfo.isGenderSelected("Male"));
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
