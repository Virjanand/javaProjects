package web.beforetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testdata.TestUser;
import testdata.TestUserProperty;
import web.LoginPage;

public class ResetPassword {

	@Test(dataProvider = "users")
	public void resetForAllUsers(String username) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://adoptiq100-test.mendixcloud.com/");
		driver.manage().window().maximize();
		final String oldPassword = "Welkom01@";
		new LoginPage(driver).loginWith(username, oldPassword);
		new LoginPage(driver).changePassword(oldPassword, TestUserProperty.getPassWord());
		driver.quit();
	}
	
	@DataProvider
	public Object[][] users() {
		return new Object[][] { 
			{ TestUser.ADVERTEERDER_EEN },
			{ TestUser.ADVERTEERDER_TWEE},
			{ TestUser.UITGEVER_EEN},
			{ TestUser.UITGEVER_TWEE},
			{ TestUser.RESELLER_EEN},
			{ TestUser.RESELLER_TWEE},
			{ TestUser.MEDIA_BUREAU},
		};
	}

}
