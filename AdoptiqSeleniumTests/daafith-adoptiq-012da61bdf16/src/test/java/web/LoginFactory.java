package web;

import org.openqa.selenium.WebDriver;

import testdata.TestUser;
import testdata.TestUserProperty;
import web.admin.HomePageAdmin;
import web.adverteerder.HomePageAdverteerder;
import web.mediabureau.HomePageMediaBureau;
import web.reseller.HomePageReseller;
import web.uitgever.HomePageUitgever;

public class LoginFactory {
	
	private static final String TEST_PASSWORD = TestUserProperty.getPassWord();

	public static HomePageUitgever loginAsUitgeverEen(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.UITGEVER_EEN, TEST_PASSWORD);
		return new HomePageUitgever(driver);
	}
	
	public static HomePageUitgever loginAsUitgeverTwee(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.UITGEVER_TWEE, TEST_PASSWORD);
		return new HomePageUitgever(driver);
	}
	
	public static HomePageReseller loginAsResellerEen(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.RESELLER_EEN, TEST_PASSWORD);
		return new HomePageReseller(driver);
	}
	
	public static HomePageReseller loginAsResellerTwee(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.RESELLER_TWEE, TEST_PASSWORD);
		return new HomePageReseller(driver);
	}
	
	public static HomePageMediaBureau loginAsMediaBureau(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.MEDIA_BUREAU, TEST_PASSWORD);
		return new HomePageMediaBureau(driver);
	}
	
	public static HomePageAdverteerder loginAsAdverteerderEen(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.ADVERTEERDER_EEN, TEST_PASSWORD);
		return new HomePageAdverteerder(driver);
	}
	
	public static HomePageAdverteerder loginAsAdverteerderTwee(WebDriver driver) {
		new LoginPage(driver).loginWith(TestUser.ADVERTEERDER_TWEE, TEST_PASSWORD);
		return new HomePageAdverteerder(driver);
	}
	
	public static HomePageAdmin loginAsAdmin(WebDriver driver) {
		new LoginPage(driver).loginWith("polteqadmin", "QoRCKT3A@1");
		return new HomePageAdmin(driver);
	}

}
