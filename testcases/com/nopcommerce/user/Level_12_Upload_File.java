package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.JQuery.HomePageDemoDataGridObject;
import pageObject.JQuery.HomePageUploadFileObject;
import pageObject.JQuery.PageGeneratorManager;

public class Level_12_Upload_File extends BaseTest {
	private WebDriver driver;
	private HomePageUploadFileObject homePageUpload;
	private String galaxyFileName = "galaxy.jpg";
	private String lighthouseFileName = "lighthouse.jpg";
	private String wolfFileName = "wolf.jpg";
	private String[] multipleFileNames = { galaxyFileName, lighthouseFileName, wolfFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = openUrl(browserName, url);
		homePageUpload = PageGeneratorManager.getHomePageUploadFile(driver);
	}

	// @Test
	public void TC_01_Upload_1_File_Per_Time() {
		homePageUpload.uploadMultipleFiles(driver, galaxyFileName);
		Assert.assertTrue(homePageUpload.isFileLoadedByName(galaxyFileName));

		homePageUpload.clickToStartButton();
		Assert.assertTrue(homePageUpload.isFileLinkUploadedByName(galaxyFileName));

		Assert.assertTrue(homePageUpload.isFileImageUploadedByName(galaxyFileName));
	}

	@Test
	public void TC_02_Upload_Multiple_File_Per_Time() {
		homePageUpload.uploadMultipleFiles(driver, multipleFileNames);
		Assert.assertTrue(homePageUpload.isFileLoadedByName(galaxyFileName));
		Assert.assertTrue(homePageUpload.isFileLoadedByName(lighthouseFileName));
		Assert.assertTrue(homePageUpload.isFileLoadedByName(wolfFileName));

		homePageUpload.clickToStartButton();

		Assert.assertTrue(homePageUpload.isFileLinkUploadedByName(galaxyFileName));
		Assert.assertTrue(homePageUpload.isFileLinkUploadedByName(lighthouseFileName));
		Assert.assertTrue(homePageUpload.isFileLinkUploadedByName(wolfFileName));

		Assert.assertTrue(homePageUpload.isFileImageUploadedByName(galaxyFileName));
		Assert.assertTrue(homePageUpload.isFileImageUploadedByName(lighthouseFileName));
		Assert.assertTrue(homePageUpload.isFileImageUploadedByName(wolfFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
