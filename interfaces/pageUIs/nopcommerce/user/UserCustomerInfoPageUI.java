package pageUIs.nopcommerce.user;

public class UserCustomerInfoPageUI {
	public static final String GENDER_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String DATE_OF_BIRTH = "css=select[name='DateOfBirthDay']";
	public static final String MONTH_OF_BIRTH = "css=select[name='DateOfBirthMonth']";
	public static final String YEAR_OF_BIRTH = "css=select[name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String COMPANY_NAME_TEXTBOX = "xpath=//input[@id='Company']";
	public static final String SAVE_BUTTON = "xpath=//button[@id='save-info-button']";
	public static final String ICON_CLOSE_UPDATE_SUCCESS_MESSAGE = "css=span.close";
	public static final String UPDATE_SUCCESS_MESSAGE = "css=div.bar-notification.success";
}
