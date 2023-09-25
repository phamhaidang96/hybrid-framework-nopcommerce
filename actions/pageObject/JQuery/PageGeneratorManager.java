package pageObject.JQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageDemoDataGridObject getHomePageDemoDataGrid(WebDriver driver) {
		return new HomePageDemoDataGridObject(driver);
	}

	public static HomePageUploadFileObject getHomePageUploadFile(WebDriver driver) {
		return new HomePageUploadFileObject(driver);
	}
}
