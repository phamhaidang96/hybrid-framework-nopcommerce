package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForAllElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public String getErrorMessageUnsuccessfull() {
		waitForAllElementVisible(driver, UserLoginPageUI.UNSUCCESS_LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.UNSUCCESS_LOGIN_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Login user with email {0} and password {1}")
	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextBox(email);
		inputToPasswordTextbox(password);
		clickToLoginButton();
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
