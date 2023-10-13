package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, UserAddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressPageUI.ADD_NEW_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserAddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserAddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserAddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, UserAddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void selectCountryDropdown(String country) {
		waitForElementVisible(driver, UserAddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressPageUI.COUNTRY_DROPDOWN, country);
	}

	public void selectStateDropdown(String state) {
		waitForElementVisible(driver, UserAddressPageUI.STATE_DROPDOWN);
		waitForElementUndisplay(driver, UserAddressPageUI.STATE_LOADING_ICON);
		selectItemInDefaultDropdown(driver, UserAddressPageUI.STATE_DROPDOWN, state);
	}

	public void inputToCityTextbox(String cityName) {
		waitForElementVisible(driver, UserAddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.CITY_TEXTBOX, cityName);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.ADDRESS1_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, UserAddressPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.ADDRESS2_TEXTBOX, address2);
	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, UserAddressPageUI.ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.ZIPCODE_TEXTBOX, zipCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, UserAddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserAddressPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressPageUI.SAVE_BUTTON);
	}

	public boolean isAddNewAddressSuccessMessageDisplay() {
		waitForElementVisible(driver, UserAddressPageUI.ADD_NEW_ADDRESS_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserAddressPageUI.ADD_NEW_ADDRESS_SUCCESS_MESSAGE);
	}

	public String isFirstNameAndLastNameDisplayed() {
		waitForElementVisible(driver, UserAddressPageUI.INFO_FIRST_NAME_AND_LAST_NAME);
		return getElementText(driver, UserAddressPageUI.INFO_FIRST_NAME_AND_LAST_NAME);
	}

	public boolean isEmailDisplayed(String infoEmail) {
		waitForElementVisible(driver, UserAddressPageUI.INFO_EMAIL);
		return isContainTextDisplayed(driver, UserAddressPageUI.INFO_EMAIL, infoEmail);
	}

	public Object isCompanyDisplayed() {
		waitForElementVisible(driver, UserAddressPageUI.INFO_COMPANY);
		return getElementText(driver, UserAddressPageUI.INFO_COMPANY);
	}

	public Object isCountrySelected() {
		waitForElementVisible(driver, UserAddressPageUI.INFO_COUNTRY);
		return getElementText(driver, UserAddressPageUI.INFO_COUNTRY);
	}

	public boolean isStateSelected(String infoState) {
		waitForElementVisible(driver, UserAddressPageUI.INFO_STATE_CITY_ZIP_CODE);
		return isContainTextDisplayed(driver, UserAddressPageUI.INFO_STATE_CITY_ZIP_CODE, infoState);
	}

	public boolean isCityDisplayed(String infoCity) {
		waitForElementVisible(driver, UserAddressPageUI.INFO_STATE_CITY_ZIP_CODE);
		return isContainTextDisplayed(driver, UserAddressPageUI.INFO_STATE_CITY_ZIP_CODE, infoCity);
	}

	public Object isAddress1Displayed() {
		waitForElementVisible(driver, UserAddressPageUI.INFO_ADDRESS1);
		return getElementText(driver, UserAddressPageUI.INFO_ADDRESS1);
	}

	public Object isAddress2Displayed() {
		waitForElementVisible(driver, UserAddressPageUI.INFO_ADDRESS2);
		return getElementText(driver, UserAddressPageUI.INFO_ADDRESS2);
	}

	public boolean isZipCodeDisplayed(String infoZipCode) {
		waitForElementVisible(driver, UserAddressPageUI.INFO_STATE_CITY_ZIP_CODE);
		return isContainTextDisplayed(driver, UserAddressPageUI.INFO_STATE_CITY_ZIP_CODE, infoZipCode);
	}

	public boolean isPhoneNumberDisplayed(String infoPhoneNumber) {
		waitForElementVisible(driver, UserAddressPageUI.INFO_PHONE_NUMBER);
		return isContainTextDisplayed(driver, UserAddressPageUI.INFO_PHONE_NUMBER, infoPhoneNumber);
	}
}
