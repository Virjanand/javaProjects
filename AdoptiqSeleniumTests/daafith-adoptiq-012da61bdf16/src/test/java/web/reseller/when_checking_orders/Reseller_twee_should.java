package web.reseller.when_checking_orders;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testdata.TestUser;
import web.AdoptiqTestScenario;
import web.LoginFactory;
import web.TestFailureListener;
import web.reseller.exchange.ResellerExchangeItem;
import web.reseller.exchange.tabs.OrderOverzichtTabReseller;

@Test(groups = {"checkOrders"}, alwaysRun = true, dependsOnGroups = {"purchase"})
@Listeners(TestFailureListener.class)
public class Reseller_twee_should extends AdoptiqTestScenario {
	
	private OrderOverzichtTabReseller recentOrders;

	@BeforeClass(alwaysRun = true)
	public void login() {
		LoginFactory.loginAsResellerTwee(driver)
			.openExchangePage();
	}

	@BeforeMethod(alwaysRun = true)
	public void openOrders() {
		recentOrders = new ResellerExchangeItem(driver).openOrderoverzicht().openOrders();
	}

	public void see_media_purchased_for_correct_prices() {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(recentOrders.getPrice(TestUser.ADVERTEERDER_TWEE)).as("Volume Discount Price")
			.isEqualTo("4.125,00");
		softly.assertAll();
	}

}
