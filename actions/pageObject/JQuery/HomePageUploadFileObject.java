package pageObject.JQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.DemoDataGrid.HomePageUploadFileUI;

public class HomePageUploadFileObject extends BasePage {
	private WebDriver driver;

	public HomePageUploadFileObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUploadFileUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUploadFileUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isElementDisplayed(driver, HomePageUploadFileUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

	public void clickToStartButton() {
		waitForAllElementVisible(driver, HomePageUploadFileUI.START_BUTTON);
		List<WebElement> startButtons = getListWebElement(driver, HomePageUploadFileUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

}
