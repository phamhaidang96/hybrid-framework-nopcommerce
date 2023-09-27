package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.Facebook.LoginPageObject;
import pageObject.Facebook.PageGeneratorManager;

public class Level_13_Element_Undisplay extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openUrl(browserName, url);
		loginPage = PageGeneratorManager.getLoginPageFacebookObject(driver);
	}

	@Test
	public void TC_01_Verify_Element_Undisplay_In_DOM() {
		loginPage.clickToCreateNewAccountButton();
		loginPage.inputToEmailTextbox("dang@gmail.com");

		verifyTrue(loginPage.isEmailAddressDisplay());

		loginPage.inputToEmailTextbox("");
		sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEnterEmailDisplay());
		verifyTrue(loginPage.isConfirmEnterEmailUndisplay());
	}

	@Test
	public void TC_02_Verify_Element_Undisplay_Not_In_DOM() {
		loginPage.clickToCloseIconAtRegisterForm();
		sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEnterEmailDisplay());
		verifyTrue(loginPage.isConfirmEnterEmailUndisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
