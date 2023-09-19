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
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_03_Register_Apply_Page_Object_Pattern {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String randEmail, firstName, lastName, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		randEmail = "automation" + randomNumber() + "@gmail.net";
		firstName = "Automation";
		lastName = "Test";
		password = "autoTest1";
	}

	@Test
	public void Register_01_Register_Empty_Data() {
		homePage.openRegisterPage();

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirtNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("test");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Success() {
		homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void Register_04_Register_Existing_Email() {
		homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Register_Password_Less_Than_6_Characters() {
		homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox("auto");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Register_Invalid_Confirm_Password() {
		homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(randEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(firstName);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
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
