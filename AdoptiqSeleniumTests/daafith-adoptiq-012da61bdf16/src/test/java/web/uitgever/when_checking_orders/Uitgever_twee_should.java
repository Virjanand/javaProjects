package web.uitgever.when_checking_orders;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testdata.TestUser;
import testdata.TestUserProperty;
import web.AdoptiqTestScenario;
import web.LoginFactory;
import web.TestFailureListener;
import web.uitgever.exchange.UitgeverExchangeItem;
import web.uitgever.exchange.tabs.OrderOverzichtTabUitgever;

@Test(groups = {"checkOrders"}, alwaysRun = true, dependsOnGroups = {"purchase"})
@Listeners(TestFailureListener.class)
public class Uitgever_twee_should extends AdoptiqTestScenario {
	
	private OrderOverzichtTabUitgever recentOrders;
	private static final String MEDIUM_BUY_NOW = TestUserProperty.getTestUsernamePrefix() + "BuyNow2";

	@BeforeClass(alwaysRun=true)
	public void login() {
		LoginFactory.loginAsUitgeverTwee(driver)
			.openExchangePage();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void openOrders() {
		recentOrders = new UitgeverExchangeItem(driver).openOrderoverzicht().openOrders();
	}
	
	public void see_media_purchased_for_correct_prices() {
		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(recentOrders.getPrice(MEDIUM_BUY_NOW)).as("Rate Card Price")
			.isEqualTo("11.000,00");
		softly.assertThat(recentOrders.getBuyer(MEDIUM_BUY_NOW)).as("Buyer")
			.isEqualTo(TestUser.ADVERTEERDER_EEN);
		
		softly.assertAll();
	}
	
}
