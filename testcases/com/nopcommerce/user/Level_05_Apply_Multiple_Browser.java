package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;

public class Level_05_Apply_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	}

	@Test
	public void Login_01_Empty_Data() {
		homePage = new UserHomePageObject(driver);
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
		// homePage = new HomePageObject(driver);
		System.out.println("Login_02 - Step 01: Click to login link");
		homePage.openLoginPage();

		System.out.println("Login_02 - Step 02: Input invalid email");
		loginPage = new UserLoginPageObject(driver);
		loginPage.inputToEmailTextBox("Test");
		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 03: Verify invalid email message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
