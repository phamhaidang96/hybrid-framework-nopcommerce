package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectMaleRadioButton() {
		waitForElementVisible(driver, CustomerInfoPageUI.MALE_RADIO_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.MALE_RADIO_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public String getUpdateSeccessfullMessage() {
		waitForElementVisible(driver, CustomerInfoPageUI.UPDATE_SUCCESS_MESSAGE);
		return getElementText(driver, CustomerInfoPageUI.UPDATE_SUCCESS_MESSAGE);
	}

}
