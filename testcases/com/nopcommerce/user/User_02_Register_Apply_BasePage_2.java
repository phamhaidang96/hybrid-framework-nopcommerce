package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_02_Register_Apply_BasePage_2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String randEmail;
	WebDriverWait explicitWait;

	// Declared (khai báo)
	BasePage basePage;
	// BasePage: class
	// basepage: Object

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		// Che giấu khởi tạo của Object
		basePage = BasePage.getBasePageObject();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

		randEmail = "automation" + randomNumber() + "@gmail.net";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "auto");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "test");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "test");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "autoTest1234");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "autoTest1234");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "auto");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "test");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", randEmail);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "autoTest1234");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "autoTest1234");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		basePage.waitForElementVisible(driver, "//div[@class='result']");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
	}

	@Test
	public void TC_04_Register_Existing_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "auto");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "test");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", randEmail);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "autoTest1234");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "autoTest1234");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Characters() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "auto");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "test");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", randEmail);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "auto");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "auto");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "test");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", randEmail);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "autoTest1234");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "autoTest12345");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
