package pageObject.JQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.DemoDataGrid.HomePageDemoDataGridUI;

public class HomePageDemoDataGridObject extends BasePage {
	private WebDriver driver;

	public HomePageDemoDataGridObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String numberPage) {
		waitForElementVisible(driver, HomePageDemoDataGridUI.PAGINATION_BY_NUMBER, numberPage);
		clickToElement(driver, HomePageDemoDataGridUI.PAGINATION_BY_NUMBER, numberPage);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageDemoDataGridUI.PAGINATION_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageDemoDataGridUI.PAGINATION_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputToHeaderByLabel(String label, String values) {
		waitForElementVisible(driver, HomePageDemoDataGridUI.HEADER_TEXTBOX_BY_LABEL, label);
		sendkeyToElement(driver, HomePageDemoDataGridUI.HEADER_TEXTBOX_BY_LABEL, values, label);
		pressKeyToElement(driver, HomePageDemoDataGridUI.HEADER_TEXTBOX_BY_LABEL, Keys.RETURN, label);
	}

	public List<String> getValueEachRowAtAllPage() {
		int pageSize = getElementSize(driver, HomePageDemoDataGridUI.TOTAL_PAGINATION);
		System.out.println("Total page" + pageSize);

		List<String> allRowValuesAllPage = new ArrayList<>();

		for (int index = 1; index <= pageSize; index++) {
			clickToElement(driver, HomePageDemoDataGridUI.PAGINATION_BY_INDEX, String.valueOf(index));

			List<WebElement> allValuesEachRow = getListWebElement(driver, HomePageDemoDataGridUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allValuesEachRow) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		for (String string : allRowValuesAllPage) {
			System.out.println(string);
		}
		return allRowValuesAllPage;
	}

	public void inputToTextboxByColumnNameAtRow(String columnName, String rowNumber, String textInput) {
		int indexColumn = getElementSize(driver, HomePageDemoDataGridUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageDemoDataGridUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(indexColumn));
		sendkeyToElement(driver, HomePageDemoDataGridUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, textInput, rowNumber,
				String.valueOf(indexColumn));
	}

	public void selectToDropDownByColumnNameAtRow(String columnName, String rowNumber, String textSelect) {
		int indexColumn = getElementSize(driver, HomePageDemoDataGridUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageDemoDataGridUI.DROPDOWM_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(indexColumn));
		selectItemInDefaultDropdown(driver, HomePageDemoDataGridUI.DROPDOWM_BY_COLUMN_INDEX_AND_ROW_INDEX, textSelect,
				rowNumber, String.valueOf(indexColumn));
	}
}
