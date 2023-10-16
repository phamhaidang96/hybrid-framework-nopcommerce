package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserComputersProductPageUI;

public class UserComputersProductPageObject extends BasePage {
	private WebDriver driver;

	public UserComputersProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public BasePage openPageAtComputersByName(String pageName) {
//		waitForElementVisible(driver, UserComputersProductPageUI.COMPUTER_SUBLIST_DYNAMIC_LINK, pageName);
//		clickToElement(driver, UserComputersProductPageUI.COMPUTER_SUBLIST_DYNAMIC_LINK, pageName);
//		switch (pageName) {
//		case "Desktops":
//			return PageGeneratorManager.getUserDesktopsProductPageObject(driver);
//		default:
//			throw new RuntimeException("Invalid page name at My Account area");
//		}
//	}
}
