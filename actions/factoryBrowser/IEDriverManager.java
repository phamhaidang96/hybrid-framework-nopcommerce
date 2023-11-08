package factoryBrowser;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		if (!IS_OS_WINDOWS) {
			throw new BrowserNotSupportedException("IE is not supported on " + System.getProperty("os.name"));
		}

		WebDriverManager.iedriver().arch32().setup();

		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();

		InternetExplorerOptions options = new InternetExplorerOptions(capability);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
		options.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, "true");
		options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, "false");
		options.setCapability("ignore Protected ModeSettings", "true");
		options.setCapability("ignore Zoom Setting", "true");
		options.setCapability("requireWindowFocus", "true");
		options.setCapability("enableElementCacheCleanup", "true");

		return new InternetExplorerDriver(options);
	}

}