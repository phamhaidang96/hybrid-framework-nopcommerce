package pageObject.Facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.FaceBook.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public void inputToEmailTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, value);
	}

	public boolean isEmailAddressDisplay() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEnterEmailDisplay() {
		waitForElementInvisible(driver, LoginPageUI.CONFIRM_ENTER_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_ENTER_EMAIL_TEXTBOX);
	}

	public boolean isConfirmEnterEmailUndisplay() {
		waitForElementUndisplay(driver, LoginPageUI.CONFIRM_ENTER_EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_ENTER_EMAIL_TEXTBOX);
	}

	public void clickToCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}

}
