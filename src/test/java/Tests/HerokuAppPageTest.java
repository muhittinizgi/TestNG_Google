package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HerokuApp;
import Utilities.Constants;

public class HerokuAppPageTest {

	WebDriver driver;
	Properties properties;
	BasePage basePage;
	HerokuApp homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		homePage = new HerokuApp(driver);   //LAUNCH HOME_PAGE
	}


	@Test 
	public void getTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("> Page title is: " + title);
		Assert.assertEquals(title, Constants.HEROKUAPP_PAGE_TITLE);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
