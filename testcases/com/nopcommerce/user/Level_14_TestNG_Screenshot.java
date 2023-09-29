package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_14_TestNG_Screenshot extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private String firstName, lastName, randEmail, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Test";
		randEmail = "automation" + randomNumber() + "@gmail.net";
		password = "autoTest1";

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		userRegisterPage = userHomePage.openRegisterPage();

		log.info("Pre-condition - Step 02: Register new user");
		userRegisterPage.registerNewUser(firstName, lastName, randEmail, password, password);
	}

	@Test
	public void TC_01_Role_User() {
		log.info("Role user - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Role user - Step 02: Navigate to 'Home' page with Email '" + randEmail + "' and Password '" + password + "'");
		userHomePage = userLoginPage.loginAsUser(randEmail, password);

		log.info("Role user - Step 03: Click to Logout link");
		userHomePage.clickLogoutLinkAtUser(driver);

		log.info("Role user - Step 04: Switch to role Admin");
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);

		log.info("Role user - Step 05: Navigate to 'Login' page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Role user - Step 06: Click to 'Login' button");
		adminLoginPage.clickToLoginButton();

		log.info("Role user - Step 07: Verify dashboard display on header");
		verifyFalse(adminLoginPage.isDashboardHeaderDisplay());
	}

	// @Test
	public void TC_02_Role_Admin() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		userLoginPage = userHomePage.openLoginPage();
		Assert.assertTrue(adminLoginPage.isDashboardHeaderDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
