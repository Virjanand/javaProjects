package web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import web.browsersession.TestConfiguration;
import web.browsersession.WebDriverSession;

/**
 * Superclass of all tests. Defines setup and tear down behavior.
 *
 */
public class AdoptiqTestScenario {
	
	protected WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	@Parameters({ "url", "browser", "language" })
	public void init(@Optional("https://adoptiq100-test.mendixcloud.com/") String url, 
			@Optional("firefox") String browser, @Optional("NL") String language) {
		TestConfiguration.setConfiguration(url, browser, language);
		driver = WebDriverSession.start();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterClass(alwaysRun=true)
	public void destroy() {
		driver.quit();
	}

}
