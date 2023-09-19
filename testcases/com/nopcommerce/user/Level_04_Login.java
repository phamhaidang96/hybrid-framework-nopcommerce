package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_04_Login {
	private WebDriver driver;
	private String projectPath, firstName, lastName, randEmail, password, notRegisterEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		randEmail = "automation" + randomNumber() + "@gmail.net";
		notRegisterEmail = "AutomationTest001@gmail.org";
		firstName = "Automation";
		lastName = "Test";
		password = "autoTest1";

		homePage = new UserHomePageObject(driver);
		System.out.println("Pre-condition: Step 01: Click to register link");
		homePage.openRegisterPage();

		System.out.println("Pre-condition: Step 02: Input valid data");
		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition: Step 03: Click register button");
		registerPage.clickToRegisterButton();
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_01 - Step 02: Click to login button");
		loginPage = new UserLoginPageObject(driver);
		loginPage.clickToLoginButton();

		System.out.println("Login_01 - Step 03: Verify error message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_02 - Step 02: Input invalid email");
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox("Test");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 03: Verify invalid email message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Not_Register_Email() {
		System.out.println("Login_03 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_03 - Step 02: Input not existing email");
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(notRegisterEmail);
		loginPage.clickToLoginButton();

		System.out.println("Login_03 - Step 03: Verify login unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_And_Empty_Password() {
		System.out.println("Login_04 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_04 - Step 02: Input existing email and empty password");
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(randEmail);
		loginPage.clickToLoginButton();

		System.out.println("Login_04 - Step 03: Verify login unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_And_Incorrect_Password() {
		System.out.println("Login_05 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_05 - Step 02: Input existing email and incorrect password");
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(randEmail);
		loginPage.inputToPasswordTextbox(firstName);
		loginPage.clickToLoginButton();

		System.out.println("Login_05 - Step 03: Verify login unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Eamil_And_Valid_Password() {
		System.out.println("Login_06 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_06 - Step 02: Input valid email and valid password");
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox(randEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		System.out.println("Login_06 - Step 03: Verify login successfully");
		Assert.assertTrue(homePage.getMyAccountLink());
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
