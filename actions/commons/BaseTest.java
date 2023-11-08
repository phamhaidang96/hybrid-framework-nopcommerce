package commons;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;
import factoryBrowser.SafariDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = GlobalConstants.PROJECT_PATH;
	protected final Log log;

	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllFileInFolder("allure-json");
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName, String environmentUrl) {
		// if (browserName.equals("firefox")) {
		// System.setProperty("webdriver.gecko.driver", projectPath +
		// "/browserDrivers/geckodriver");
		// driver = new FirefoxDriver();
		// } else if (browserName.equals("h_firefox")) {
		// System.setProperty("webdriver.gecko.driver", projectPath +
		// "/browserDrivers/geckodriver");
		// FirefoxOptions options = new FirefoxOptions();
		// options.addArguments("--headless");
		// options.addArguments("window-size=1900x1080");
		// driver = new FirefoxDriver(options);
		// } else if (browserName.equals("edge")) {
		// System.setProperty("webdriver.edge.driver", projectPath +
		// "/browserDrivers/msedgedriver");
		// driver = new EdgeDriver();
		// } else if (browserName.equals("chrome")) {
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "/browserDrivers/chromedriver");
		// driver = new ChromeDriver();
		// } else if (browserName.equals("h_chrome")) {
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "/browserDrivers/chromedriver");
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		// options.addArguments("window-size=1900x1080");
		// driver = new ChromeDriver(options);
		// } else if (browserName.equals("coccoc")) {
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "/browserDrivers/chromedriver114");
		// ChromeOptions options = new ChromeOptions();
		// options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
		// driver = new ChromeDriver(options);
		// } else if (browserName.equals("safari")) {
		// driver = new SafariDriver();
		// } else {
		// throw new RuntimeException("Browser name is not valid.");
		// }

//		if (browserName.equals("firefox")) {
//			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
//					GlobalConstants.BROWSER_LOG_FOLDER + "FirefoxLog.log");
//
//			driver = WebDriverManager.firefoxdriver().create();
//		} else if (browserName.equals("h_firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1900x1080");
//			driver = new FirefoxDriver(options);
//		} else if (browserName.equals("edge")) {
//			driver = WebDriverManager.edgedriver().create();
//		} else if (browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "true");
//
//			driver = WebDriverManager.chromedriver().create();
//		} else if (browserName.equals("h_chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1900x1080");
//			driver = new ChromeDriver(options);
//		} else if (browserName.equals("coccoc")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver114");
//			ChromeOptions options = new ChromeOptions();
//			options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
//			driver = new ChromeDriver(options);
//		} else if (browserName.equals("safari")) {
//			driver = new SafariDriver();
//		} else {
//			throw new RuntimeException("Browser name is not valid.");
//		}

		if (browserName.equals("firefox")) {
			driver = new FirefoxDriverManager().getBrowserDriver();
		} else if (browserName.equals("h_firefox")) {
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
		} else if (browserName.equals("chrome")) {
			driver = new ChromeDriverManager().getBrowserDriver();
		} else if (browserName.equals("h_chrome")) {
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriverManager().getBrowserDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriverManager().getBrowserDriver();
		} else {
			throw new RuntimeException("Browser name is not valid.");
		}

		driver.get(environmentUrl);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
					GlobalConstants.BROWSER_LOG_FOLDER + "FirefoxLog.log");

			driver = WebDriverManager.firefoxdriver().create();
		} else if (browserName.equals("h_firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1900x1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");

			driver = WebDriverManager.chromedriver().create();
		} else if (browserName.equals("h_chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1900x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("coccoc")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver114");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			throw new RuntimeException("Browser name is not valid.");
		}

		driver.get(GlobalConstants.USER_PAGE_URL);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected String getEnvironmentUrl(String environmentName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(environmentName.toUpperCase());
		switch (environment) {
		case STAGING_USER:
			envUrl = GlobalConstants.USER_PAGE_URL;
			break;
		case STAGING_ADMIN:
			envUrl = GlobalConstants.ADMIN_PAGE_URL;
			break;
		case DEV:
			envUrl = "";
			break;
		case PROD:
			envUrl = "";
			break;
		default:
			return envUrl = null;
		}
		return envUrl;
	}

	protected int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	protected WebDriver openUrl(String browserName, String url) {
		if (browserName.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else {
			throw new RuntimeException("Browser name is not valid.");
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
