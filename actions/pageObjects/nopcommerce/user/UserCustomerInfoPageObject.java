package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMaleRadioButton() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MALE_RADIO_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.MALE_RADIO_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
	}

	public String getUpdateSeccessfullMessage() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.UPDATE_SUCCESS_MESSAGE);
		return getElementText(driver, UserCustomerInfoPageUI.UPDATE_SUCCESS_MESSAGE);
	}

}
