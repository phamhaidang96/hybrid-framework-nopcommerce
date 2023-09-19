package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.admin.AdminLoginUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginUI.LOGIN_BUTTON);
	}

	public boolean isDashboardHeaderDisplay() {
		waitForElementVisible(driver, AdminLoginUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminLoginUI.DASHBOARD_HEADER);
	}

}
