package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = GlobalConstants.PROJECT_PATH;

	protected WebDriver getBrowserDriver(String browserName) {
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

		if (browserName.equals("firefox")) {
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

}
