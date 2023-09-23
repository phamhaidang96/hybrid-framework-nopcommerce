package com.nopcommerce.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class Level_10_Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private UserAddressPageObject userAddressPage;
	private UserChangePasswordPageObject userChangePassword;
	private UserCustomerInfoPageObject userCustomerInfor;
	private UserMyProductReviewPageObject userMyProductReview;
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
	public void TC_01_Switch_Page_Use_Dynamic_Locator_1() {
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(randEmail, password);
		// userHomePage.clickLogoutLinkAtUser(driver);
		//
		// userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		// adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		// adminLoginPage.clickToLoginButton();
		// Assert.assertTrue(adminLoginPage.isDashboardHeaderDisplay());
		// adminLoginPage.clickLogoutLinkAtAdmin(driver);
		//
		// adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		// userHomePage = PageGeneratorManager.getUserHomePage(driver);
		// userLoginPage = userHomePage.openLoginPage();
		//
		// userHomePage = userLoginPage.loginAsUser(randEmail, password);
		userCustomerInfor = userHomePage.openMyAccountPage();

		userAddressPage = (UserAddressPageObject) userCustomerInfor.openPagesAtMyAccountByName(driver, "Addresses");

		userChangePassword = (UserChangePasswordPageObject) userAddressPage.openPagesAtMyAccountByName(driver, "Change password");

		userMyProductReview = (UserMyProductReviewPageObject) userChangePassword.openPagesAtMyAccountByName(driver, "My product reviews");

		userCustomerInfor = (UserCustomerInfoPageObject) userMyProductReview.openPagesAtMyAccountByName(driver, "Customer info");
	}

	@Test
	public void TC_01_Switch_Page_Use_Dynamic_Locator_2() {
		userCustomerInfor.openPagesAtMyAccountByPageName(driver, "Addresses");
		userAddressPage = PageGeneratorManager.getUserAddressPage(driver);

		userAddressPage.openPagesAtMyAccountByPageName(driver, "Change password");
		userChangePassword = PageGeneratorManager.getUserChangePasswordPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
