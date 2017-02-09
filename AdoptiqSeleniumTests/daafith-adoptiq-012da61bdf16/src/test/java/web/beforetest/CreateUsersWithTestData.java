package web.beforetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import testdata.TestUserProperty;
import web.LoginFactory;

@Test
public class CreateUsersWithTestData {

	private static final String TEST_USERNAME_PREFIX = TestUserProperty.getTestUsernamePrefix();

	public void startUnitTests() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://adoptiq100-test.mendixcloud.com/");
		driver.manage().window().maximize();
		
		LoginFactory.loginAsAdmin(driver)
			.openDevelopPage()
			.openUnitTestsPage()
			.startMediaTestsForUserName(TEST_USERNAME_PREFIX);
		
		
		//TODO: make dependent on loading screen
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.quit();
		
	}
	
}