package example;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class SimpleNavigationTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public void navigateToNuNl() {
		driver.get("http://www.nu.nl");
		assertThat(driver.getTitle(), equalTo("NU - Het laatste nieuws het eerst op NU.nl"));
	}
	


}
