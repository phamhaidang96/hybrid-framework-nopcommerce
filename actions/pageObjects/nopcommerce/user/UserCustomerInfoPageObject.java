package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGenderByText(String gender) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_BY_TEXT, gender);
		clickToElement(driver, UserCustomerInfoPageUI.GENDER_BY_TEXT, gender);
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

	public void selectDateOfBirthDropdown(String dateOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH, dateOfBirth);
	}

	public void selectMonthOfBirthDropdown(String monthOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH, monthOfBirth);
	}

	public void selectYearOfBirthDropdown(String yearOfBirth) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH, yearOfBirth);
	}

	public boolean isUpdateSuccessfullyMessageDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.UPDATE_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.UPDATE_SUCCESS_MESSAGE);
	}

	public boolean isGenderSelected(String gender) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_BY_TEXT, gender);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_BY_TEXT, gender);
	}

	public String isFirstNameUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String isLastNameUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String isDateOfBirthUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH);
	}

	public String isMonthOfBirthUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.MONTH_OF_BIRTH);
	}

	public String isYearOfBirthUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.YEAR_OF_BIRTH);
	}

	public String isEmailUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String isCompanyNameUpdated() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}
}
