package pageObject.demoDataGrid;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageDemoDataGridObject getHomePageDemoDataGrid(WebDriver driver) {
		return new HomePageDemoDataGridObject(driver);
	}
}
