package pageObjects.nopcommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserDesktopPrductPageUI;

public class UserDesktopsProductPageObject extends BasePage {
	WebDriver driver;

	public UserDesktopsProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortByDropdownByOption(String shortOption) {
		waitForElementVisible(driver, UserDesktopPrductPageUI.SHORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserDesktopPrductPageUI.SHORT_BY_DROPDOWN, shortOption);
	}

	public boolean isProductSortByNameAscending() {
		// Khai báo List chứa product Name
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy all locator chứa product name
		waitForElementUndisplay(driver, UserDesktopPrductPageUI.PRODUCT_BUSY_LOADING_ICON);
		List<WebElement> productNames = getListWebElement(driver, UserDesktopPrductPageUI.PRODUCTS_NAME);

		// Gettext của product name đưa vào list khai báo ở trên
		for (WebElement productName : productNames) {
			productUIList.add(productName.getText());
			System.out.println("Data trên UI: " + productName.getText());
		}

		// Copy ra 1 List mới để sort data
		ArrayList<String> sortProductUIList = new ArrayList<String>();
		for (String product : productUIList) {
			sortProductUIList.add(product);
		}

		// Thực hiện sort data
		Collections.sort(sortProductUIList);
		for (String product : sortProductUIList) {
			System.out.println("Data sau khi sort ASC: " + product);
		}

		// Verify 2 mảng bằng nhau
		return sortProductUIList.equals(productUIList);
	}

	public boolean isProductSortByNameDescending() {
		// Khai báo List chứa product Name
		ArrayList<String> productUIList = new ArrayList<>();

		// Lấy all locator chứa product name
		waitForElementUndisplay(driver, UserDesktopPrductPageUI.PRODUCT_BUSY_LOADING_ICON);
		List<WebElement> productNames = getListWebElement(driver, UserDesktopPrductPageUI.PRODUCTS_NAME);

		// Gettext của product name đưa vào list khai báo ở trên
		for (WebElement productName : productNames) {
			productUIList.add(productName.getText());
			System.out.println("Data trên UI: " + productName.getText());
		}

		// Copy ra 1 List mới để sort data
		ArrayList<String> sortProductUIList = new ArrayList<>();
		for (String product : productUIList) {
			sortProductUIList.add(product);
		}

		// Thực hiện sort data ASC
		Collections.sort(sortProductUIList);
		for (String product : sortProductUIList) {
			System.out.println("Data sau khi sort ASC: " + product);
		}

		// Thực hiện sort data DESC
		Collections.reverse(sortProductUIList);
		for (String product : sortProductUIList) {
			System.out.println("Data sau khi sort DESC: " + product);
		}

		// Verify 2 mảng bằng nhau
		return sortProductUIList.equals(productUIList);
	}

	public boolean isProductSortByPriceAscending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		waitForElementUndisplay(driver, UserDesktopPrductPageUI.PRODUCT_BUSY_LOADING_ICON);
		List<WebElement> productPrices = getListWebElement(driver, UserDesktopPrductPageUI.PRODUCTS_PRICE);
		for (WebElement productPrice : productPrices) {
			productUIList.add(Float.parseFloat(productPrice.getText().substring(1).replace(",", "")));
			System.out.println("Data trên UI: " + productPrice.getText());
		}
		ArrayList<Float> sortProductUIList = new ArrayList<Float>();
		for (Float product : productUIList) {
			sortProductUIList.add(product);
		}
		Collections.sort(sortProductUIList);
		for (Float product : sortProductUIList) {
			System.out.println("Data sau khi sort ASC: " + product);
		}
		return sortProductUIList.equals(productUIList);
	}

	public boolean isProductSortByFriceDescending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		waitForElementUndisplay(driver, UserDesktopPrductPageUI.PRODUCT_BUSY_LOADING_ICON);
		List<WebElement> productPrices = getListWebElement(driver, UserDesktopPrductPageUI.PRODUCTS_PRICE);
		for (WebElement productPrice : productPrices) {
			productUIList.add(Float.parseFloat(productPrice.getText().substring(1).replace(",", "")));
			System.out.println("Data trên UI: " + productPrice.getText());
		}
		ArrayList<Float> sortProductUIList = new ArrayList<Float>();
		for (Float product : productUIList) {
			sortProductUIList.add(product);
		}
		Collections.sort(sortProductUIList);
		for (Float product : sortProductUIList) {
			System.out.println("Data sau khi sort ASC: " + product);
		}
		Collections.reverse(sortProductUIList);
		for (Float product : sortProductUIList) {
			System.out.println("Data sau khi sort DESC: " + product);
		}
		return sortProductUIList.equals(productUIList);
	}
}
