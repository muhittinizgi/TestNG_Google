package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class HerokuApp extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	
	public HerokuApp(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getHomePageTitle() {
		driver.get("https://www.heroku.com/");
		return elementUtil.waitForGetPageTitle(Constants.HEROKUAPP_PAGE_TITLE);
	}


}
