package com.nopcommerce.user;

import java.io.File;

public class Level_09_String_Format {
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='My product reviews']";

	public static String DYNAMIC_LINK_BY_PAGE_NAME = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
	public static String DYNAMIC_LINK_PAGE_NAME = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";

	public static void main(String[] args) {

		// clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "Addresses");
		// clickToLink(DYNAMIC_LINK_PAGE_NAME, "block-account-navigation", "Addresses");

		System.out.println(PROJECT_PATH);
		System.out.println(UPLOAD_FILE_FOLDER);
	}

	// // 1 tham số động
	// public static void clickToLink(String dynamicLocator, String pageName) {
	// String locator = String.format(dynamicLocator, pageName);
	// System.out.println(locator);
	// }
	//
	// // 2 tham số động
	// public static void clickToLink(String dynamicLocator, String areaName, String
	// pageName) {
	// String locator = String.format(dynamicLocator, areaName, pageName);
	// System.out.println(locator);
	// }

	// 1 -> n tham số động
	public static void clickToLink(String dynamicLink, String... params) {
		String locator = String.format(dynamicLink, (Object[]) params);
		System.out.println(locator);
	}
}
