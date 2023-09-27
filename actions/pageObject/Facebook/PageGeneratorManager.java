package pageObject.Facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPageFacebookObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
