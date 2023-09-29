package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

public class Level_14_Extent_Report_v5 extends BaseTest {
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

	}

	@Test
	public void TC_01_Role_User_Register(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Pre-condition");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Pre-condition - Step 01: Navigate to 'Register' page");
		userRegisterPage = userHomePage.openRegisterPage();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Pre-condition - Step 02: Register new user");
		userRegisterPage.registerNewUser(firstName, lastName, randEmail, password, password);
	}

	@Test
	public void TC_02_Role_User_Login(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "TC_01_Role_User");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 01: Navigate to 'Login' page");
		userLoginPage = userHomePage.openLoginPage();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 02: Navigate to 'Home' page with Email '" + randEmail + "' and Password '" + password + "'");
		userHomePage = userLoginPage.loginAsUser(randEmail, password);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 03: Click to Logout link");
		userHomePage.clickLogoutLinkAtUser(driver);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 04: Switch to role Admin");
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 05: Navigate to 'Login' page");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 06: Click to 'Login' button");
		adminLoginPage.clickToLoginButton();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Role user - Step 07: Verify dashboard display on header");
		Assert.assertFalse(adminLoginPage.isDashboardHeaderDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
