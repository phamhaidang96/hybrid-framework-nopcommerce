package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Common_02_Register_New_Account_Cookie extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private String firstName, lastName, randEmail, password;
	public static Set<Cookie> loggedCookies;

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

		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsUser(randEmail, password);

		loggedCookies = userHomePage.getAllCookies(driver);
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}
}
