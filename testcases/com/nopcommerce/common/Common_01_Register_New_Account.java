package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Common_01_Register_New_Account extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	public static String randEmail, password;
	private String firstName, lastName;

	@Parameters("browser")
	@BeforeTest(description = "Create new commons User for all classes test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Test";
		randEmail = "automation" + randomNumber() + "@gmail.net";
		password = "autoTest1";

		userRegisterPage = userHomePage.openRegisterPage();

		userRegisterPage.registerNewUser(firstName, lastName, randEmail, password, password);
		driver.quit();
	}
}
