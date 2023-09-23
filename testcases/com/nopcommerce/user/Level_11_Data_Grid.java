package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.demoDataGrid.HomePageDemoDataGridObject;
import pageObject.demoDataGrid.PageGeneratorManager;

public class Level_11_Data_Grid extends BaseTest {
	private WebDriver driver;
	private HomePageDemoDataGridObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openUrl(browserName, url);
		homePage = PageGeneratorManager.getHomePageDemoDataGrid(driver);
	}

	// @Test
	public void TC_01_Paging() {
		homePage.openPagingByPageNumber("10");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("10"));

		homePage.openPagingByPageNumber("2");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("2"));

		homePage.openPagingByPageNumber("21");
		sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("21"));
	}

	// @Test
	public void TC_02_Input_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.inputToHeaderByLabel("Females", "276880");
		homePage.inputToHeaderByLabel("Country", "Angola");
		homePage.inputToHeaderByLabel("Males", "276472");
		homePage.inputToHeaderByLabel("Total", "553353");
	}

	@Test
	public void TC_03_Get_Value_All_Page() {
		homePage.refreshCurrentPage(driver);
		homePage.getValueEachRowAtAllPage();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
