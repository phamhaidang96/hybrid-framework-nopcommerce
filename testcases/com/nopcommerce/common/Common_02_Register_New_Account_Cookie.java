package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Common_02_Register_New_Account_Cookie extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private DataHelper dataFaker;
	private String firstName, lastName, randEmail, password;
	public static Set<Cookie> loggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new commons User for all classes test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		dataFaker = DataHelper.getData();
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		randEmail = dataFaker.getEmail();
		password = dataFaker.getPassword();

		userRegisterPage = userHomePage.openRegisterPage();

		log.info("Register new user with info: ");
		log.info("First name: " + firstName);
		log.info("Last name: " + lastName);
		log.info("Email: " + randEmail);
		log.info("Password: " + password);
		userRegisterPage.registerNewUser(firstName, lastName, randEmail, password, password);

		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsUser(randEmail, password);

		loggedCookies = userHomePage.getAllCookies(driver);

		closeBrowserDriver();
	}
}