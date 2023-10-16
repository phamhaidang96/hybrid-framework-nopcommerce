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
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_07_My_Account_Apply_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private String firstName, lastName, randEmail, password, updateFirstName, updateLastName, updateEmail, companyName;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		randEmail = "automation" + randomNumber() + "@gmail.net";
		firstName = "Automation";
		lastName = "Test";
		password = "autoTest1";

		updateFirstName = "Autotest";
		updateLastName = "FC";
		updateEmail = "Autofc" + randomNumber() + "@gmail.org";
		companyName = "Automation FC";

		System.out.println("Pre-condition: Step 01: Click to register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Pre-condition: Step 02: Input valid data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition: Step 03: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition: Step 04: Click login link");
		loginPage = homePage.openLoginPage();

		System.out.println("Pre-condition: Step 05: Input valid email and valid password");
		loginPage.inputToEmailTextBox(randEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
	}

	@Test
	public void MyAccount_01_Update_Info() {
		System.out.println("MyAccount_01 - Step 01: Open customer info page");
		customerInfoPage = homePage.openMyAccountPage();

		System.out.println("MyAccount_01 - Step 02: Update user data");
		customerInfoPage.selectGenderByText("Male");
		customerInfoPage.inputToFirstNameTextbox(updateFirstName);
		customerInfoPage.inputToLastNameTextbox(updateLastName);
		customerInfoPage.inputToEmailTextbox(updateEmail);
		customerInfoPage.inputToCompanyNameTextbox(companyName);

		System.out.println("MyAccount_01 - Step 03: Click button Save");
		customerInfoPage.clickToSaveButton();

		System.out.println("MyAccount_01 - Step 04: Verify update sucessfull");
		Assert.assertEquals(customerInfoPage.getUpdateSeccessfullMessage(), "The customer info has been updated successfully.");
	}

	@Test
	public void MyAccount_Swich_Page() {
		changePasswordPage = customerInfoPage.openChangePasswordPage(driver);

		myProductReviewPage = changePasswordPage.openMyProductReviewPage(driver);

		addressPage = myProductReviewPage.openAddressPage(driver);

		customerInfoPage = addressPage.openCustomerInfoPage(driver);
	}

	@Test
	public void MyAccount_02_Add_Address() {

	}

	@Test
	public void MyAccount_03_Change_Password() {

	}

	@Test
	public void MyAccount_04_Review_Product() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
