package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public boolean isChangePasswordSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}
}
