package pageUIs.nopcommerce.user;

public class BasePageUI {
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";
	public static final String MY_ACCOUNT_DYNAMIC_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
	public static final String USER_LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	public static final String ADMIN_BUSY_LOADING = "xpath=//div[@id='ajaxBusy']";
	public static final String COMPUTERS_LINK = "xpath=//ul[@class='top-menu notmobile']//a[contains(string(),'Computers')]";
	public static final String COMPUTER_SUBLIST_DYNAMIC_LINK = "xpath=//ul[@class='sublist']//a[contains(string(),'%s')]";
}
