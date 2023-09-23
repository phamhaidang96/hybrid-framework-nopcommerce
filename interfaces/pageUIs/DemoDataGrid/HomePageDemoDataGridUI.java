package pageUIs.DemoDataGrid;

public class HomePageDemoDataGridUI {
	public static final String PAGINATION_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=li.qgrd-pagination-page";
	public static final String PAGINATION_BY_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
}
