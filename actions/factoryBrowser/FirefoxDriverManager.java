package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		// Ignore log in the console
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				GlobalConstants.BROWSER_LOG_FOLDER + "FirefoxLog.log");

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");

		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_FILE_FOLDER);
		options.addPreference("browser.download.useDownload Dir", true);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,a pplication/csv,text/csv,image/png,image/jpeg, application/pdf, text/html, text/plain, application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
		options.addPreference("pdfjs.disabled", true);

		// Chạy ẩn danh
		// options.addArguments("-private");

		return new FirefoxDriver(options);
	}

}
