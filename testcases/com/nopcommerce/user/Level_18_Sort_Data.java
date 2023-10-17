package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserComputersProductPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserDesktopsProductPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Level_18_Sort_Data extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserAddressPageObject userAddress;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfo;
	private UserChangePasswordPageObject userChangePassword;
	private UserMyProductReviewPageObject userMyProductReview;
	private UserComputersProductPageObject userComputers;
	private UserDesktopsProductPageObject userDesktops;
	private DataHelper dataFaker;
	private String firstName, lastName, email, password;
	private String updateFirstName, updateLastName, updateDateOfBirth, updateMonthOfBirth, updateYearOfBirth, updateEmail, updateCompanyName, updateGender;
	private String country, state, city, address1, address2, zipCode, phoneNumber;
	private String oldPassword, newPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		dataFaker = DataHelper.getData();
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmail();
		password = dataFaker.getPassword();

		updateGender = "Male";
		updateFirstName = dataFaker.getFirstName();
		updateLastName = dataFaker.getLastName();
		updateDateOfBirth = "3";
		updateMonthOfBirth = "March";
		updateYearOfBirth = "2022";
		updateEmail = dataFaker.getEmail();
		updateCompanyName = dataFaker.getCompanyName();

		country = "United States";
		state = "Alaska";
		city = dataFaker.getCityName();
		address1 = dataFaker.getFullAddress();
		address2 = dataFaker.getSecondAddress();
		zipCode = dataFaker.getZipcode();
		phoneNumber = dataFaker.getPhoneNumber();

		oldPassword = password;
		newPassword = dataFaker.getPassword();

		userRegisterPage = userHomePage.openRegisterPage();

		log.info("Pre-condition:\n Register new user with info: ");
		log.info("First name '" + firstName + "'");
		log.info("Last name '" + lastName + "'");
		log.info("Email '" + email + "'");
		log.info("Password '" + password + "'\n");
		userRegisterPage.registerNewUser(updateFirstName, updateLastName, email, password, password);

		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsUser(email, password);

		userCustomerInfo = userHomePage.openMyAccountPage();
	}

	@Test
	public void TC_01_Update_Customer_info() {
		log.info("TC_01 - Step 01: Update Gender to '" + updateGender + "'");
		userCustomerInfo.selectGenderByText(updateGender);

		log.info("TC_01 - Step 02: Update First name to '" + updateFirstName + "'");
		userCustomerInfo.inputToFirstNameTextbox(updateFirstName);

		log.info("TC_01 - Step 03: Update Last name to '" + updateLastName + "'");
		userCustomerInfo.inputToLastNameTextbox(updateLastName);

		log.info("TC_01 - Step 04: Update Date of birth to '" + updateDateOfBirth + "'");
		userCustomerInfo.selectDateOfBirthDropdown(updateDateOfBirth);

		log.info("TC_01 - Step 05: Update Month of birth to '" + updateMonthOfBirth + "'");
		userCustomerInfo.selectMonthOfBirthDropdown(updateMonthOfBirth);

		log.info("TC_01 - Step 06: Update Year of birth to '" + updateYearOfBirth + "'");
		userCustomerInfo.selectYearOfBirthDropdown(updateYearOfBirth);

		log.info("TC_01 - Step 07: Update Email to '" + updateEmail + "'");
		userCustomerInfo.inputToEmailTextbox(updateEmail);

		log.info("TC_01 - Step 08: Update Company name to '" + updateCompanyName + "'");
		userCustomerInfo.inputToCompanyNameTextbox(updateCompanyName);

		log.info("TC_01 - Step 09: Click button 'Save'");
		userCustomerInfo.clickToSaveButton();

		log.info("TC_01 - Step 10: Verify data updated" + "\n");
		Assert.assertTrue(userCustomerInfo.isUpdateSuccessfullyMessageDisplayed());
		Assert.assertTrue(userCustomerInfo.isGenderSelected(updateGender));
		Assert.assertEquals(userCustomerInfo.isFirstNameUpdated(), updateFirstName);
		Assert.assertEquals(userCustomerInfo.isLastNameUpdated(), updateLastName);
		Assert.assertEquals(userCustomerInfo.isDateOfBirthUpdated(), updateDateOfBirth);
		Assert.assertEquals(userCustomerInfo.isMonthOfBirthUpdated(), updateMonthOfBirth);
		Assert.assertEquals(userCustomerInfo.isYearOfBirthUpdated(), updateYearOfBirth);
		Assert.assertEquals(userCustomerInfo.isEmailUpdated(), updateEmail);
		Assert.assertEquals(userCustomerInfo.isCompanyNameUpdated(), updateCompanyName);
	}

	@Test
	public void TC_02_Add_Addresses() {
		log.info("TC_02 - Step 01: Open 'Addresses' page");
		userAddress = userCustomerInfo.openAddressPage(driver);

		log.info("TC_02 - Step 02: Click button 'Add new'");
		userAddress.clickToAddNewButton();

		log.info("TC_02 - Step 03: Input to First name textbox with value is '" + updateFirstName + "'");
		userAddress.inputToFirstNameTextbox(updateFirstName);

		log.info("TC_02 - Step 04: Input to Last name textbox with value is '" + updateLastName + "'");
		userAddress.inputToLastNameTextbox(updateLastName);

		log.info("TC_02 - Step 05: Input to Email textbox with value is '" + updateEmail + "'");
		userAddress.inputToEmailTextbox(updateEmail);

		log.info("TC_02 - Step 06: Input to Company textbox with value is '" + updateCompanyName + "'");
		userAddress.inputToCompanyTextbox(updateCompanyName);

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
		verifyEquals(userAddress.isFirstNameAndLastNameDisplayed(), updateFirstName + " " + updateLastName);
		verifyTrue(userAddress.isEmailDisplayed(updateEmail));
		verifyEquals(userAddress.isCompanyDisplayed(), updateCompanyName);
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
		log.info("TC_04 - Step 01: Open 'Computers' page");
		userComputers = userChangePassword.openComputerPageObject(driver);

		log.info("TC_04 - Step 02: Open 'Desktops' page");
		userDesktops = (UserDesktopsProductPageObject) userComputers.openPagesAtComputersByName(driver, "Desktops");

		log.info("TC_04 - Step 03: Select Sort by 'Name: A to Z'");
		userDesktops.selectSortByDropdownByOption("Name: A to Z");

		log.info("TC_04 - Step 04: Verify Sort by 'Name: A to Z'");
		verifyTrue(userDesktops.isProductSortByNameAscending());

		log.info("TC_04 - Step 05: Select Sort by 'Name: Z to A'");
		userDesktops.selectSortByDropdownByOption("Name: Z to A");

		log.info("TC_04 - Step 06: Verify Sort by 'Name: Z to A'");
		verifyTrue(userDesktops.isProductSortByNameDescending());

		log.info("TC_04 - Step 07: Select Sort by 'Price: Low to High'");
		userDesktops.selectSortByDropdownByOption("Price: Low to High");
		sleepInSecond(3);

		log.info("TC_04 - Step 08: Verify Sort by 'Price: Low to High'");
		verifyTrue(userDesktops.isProductSortByPriceAscending());

		log.info("TC_04 - Step 09: Select Sort by 'Price: High to Low'");
		userDesktops.selectSortByDropdownByOption("Price: High to Low");

		log.info("TC_04 - Step 10: Verify Sort by 'Price: High to Low'");
		verifyTrue(userDesktops.isProductSortByFriceDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
