package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_02_Register_New_Account_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserMyProductReviewPageObject userMyAccountObject;
	// private UserRegisterPageObject userRegisterPage;
	// private UserLoginPageObject userLoginPage;
	// private AdminLoginPageObject adminLoginPage;
	// private String firstName, lastName, randEmail, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_01_Role_User() {
		userHomePage.openLoginPage();

		log.info("Role user - Step 01: Set cookie and reload page");
		userHomePage.setCookie(driver, Common_02_Register_New_Account_Cookie.loggedCookies);
		userHomePage.refreshCurrentPage(driver);

		Assert.assertTrue(userHomePage.getMyAccountLink());

		log.info("Role user - Step 02: Open My Account page");
		userHomePage.openMyAccountPage();

		log.info("Role user - Step 03: Open Addresses page");
		userMyAccountObject.openPagesAtMyAccountByPageName(driver, "Addresses");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
