package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HomePage;
import Utilities.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties properties;
	BasePage basePage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		homePage = new HomePage(driver);   //LAUNCH HOME_PAGE

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test   (description = "Launch Google home page and verify the title")
	public void getTitle() {
		String title = homePage.getHomePageTitle();
		System.out.println("> Page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
