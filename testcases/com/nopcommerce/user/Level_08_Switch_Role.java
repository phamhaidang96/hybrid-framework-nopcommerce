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

public class Level_08_Switch_Role extends BaseTest {
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

		userRegisterPage = userHomePage.openRegisterPage();
		userRegisterPage.registerNewUser(firstName, lastName, randEmail, password, password);
	}

	@Test
	public void TC_01_Role_User() {
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(randEmail, password);
		userHomePage.clickLogoutLinkAtUser(driver);

		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.clickToLoginButton();
		Assert.assertTrue(adminLoginPage.isDashboardHeaderDisplay());
		adminLoginPage.clickLogoutLinkAtAdmin(driver);
	}

	// @Test
	public void TC_02_Role_Admin() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.clickToLoginButton();
		Assert.assertTrue(adminLoginPage.isDashboardHeaderDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
