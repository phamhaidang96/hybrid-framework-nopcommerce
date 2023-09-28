package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
//import commons.GlobalConstants;
import commons.PageGeneratorManager;
//import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
//import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentManager;

public class Level_16_Extent_Report_v2 extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	// private UserLoginPageObject userLoginPage;
	// private AdminLoginPageObject adminLoginPage;
	private String firstName, lastName, randEmail, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, Method method) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "Test";
		randEmail = "automation" + randomNumber() + "@gmail.net";
		password = "autoTest1";

		// ExtentManager.startTest(method.getName(), "Pre-condition");
		// ExtentManager.getTest().log(LogStatus.INFO, "Pre-condition - Step 01:
		// Navigate to 'Register' page");
		userRegisterPage = userHomePage.openRegisterPage();

		// ExtentManager.getTest().log(LogStatus.INFO, "Pre-condition - Step 02:
		// Register new user");
		userRegisterPage.registerNewUser(firstName, lastName, randEmail, password, password);
		// ExtentManager.endTest();
	}

	@Test
	public void TC_01_Role_User(Method method) {
		// ExtentManager.startTest(method.getName(), "TC_01_Role_User");
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 01: Navigate to
		// 'Login' page");
		// userLoginPage = userHomePage.openLoginPage();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 02: Navigate to
		// 'Home' page with Email '" + randEmail + "' and Password '" + password + "'");
		// userHomePage = userLoginPage.loginAsUser(randEmail, password);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 03: Click to
		// Logout link");
		// userHomePage.clickLogoutLinkAtUser(driver);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 04: Switch to
		// role Admin");
		// userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 05: Navigate to
		// 'Login' page");
		// adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 06: Click to
		// 'Login' button");
		// adminLoginPage.clickToLoginButton();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Role user - Step 07: Verify
		// dashboard display on header");
		// Assert.assertFalse(adminLoginPage.isDashboardHeaderDisplay());
		//
		// ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
