package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to 'Register' page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Navigate to 'Login' page")
	public UserLoginPageObject openLoginPage() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify 'My Account' Link is displayed")
	public boolean getMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Navigate to 'Customer Info' page")
	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public void closeMessageLoginSuccessfully() {
		waitForElementVisible(driver, UserHomePageUI.ICON_CLOSE_LOGIN_SUCCESS_MESSAGE);
		clickToElement(driver, UserHomePageUI.ICON_CLOSE_LOGIN_SUCCESS_MESSAGE);
		waitForElementUndisplay(driver, UserHomePageUI.ICON_CLOSE_LOGIN_SUCCESS_MESSAGE);
	}
}