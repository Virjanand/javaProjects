package web.adverteerder.when_purchasing;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import testdata.TestUser;
import testdata.TestUserProperty;
import web.AdoptiqTestScenario;
import web.LoginFactory;
import web.TestFailureListener;
import web.adverteerder.HomePageAdverteerder;
import web.adverteerder.exchange.pages.ExchangePageAdverteerder;
import web.adverteerder.exchange.pages.PurchaseConfirmation;
import web.adverteerder.exchange.pages.ExchangePageAdverteerder.Filter;
import web.adverteerder.exchange.tabs.OrderOverzichtTabAdverteerder;

@Test(groups = {"purchase"})
@Listeners(TestFailureListener.class)
public class Adverteerder_twee_should extends AdoptiqTestScenario {

	private static final String FULL_PAGE = "CD101V";
	private static final String MEDIUM_BUY_NOW = TestUserProperty.getTestUsernamePrefix() + "BuyNow2";
	private static final String MEDIUM_RATE_CARD_CONTRACT = TestUserProperty.getTestUsernamePrefix() + "BuyNow";

	private ExchangePageAdverteerder exchangePage;

	@BeforeClass(alwaysRun = true)
	public void login() {
		 LoginFactory.loginAsAdverteerderTwee(driver);
			
	}
	
	//TODO: should I be refactored?
	private void filterResults(String medium) {
		new HomePageAdverteerder(driver).openExchangePage()
			.selectFilterOptions(Filter.MEDIUM, new String[] {medium})
			.selectFilterOptions(Filter.FORMAAT_CODE, new String[] {FULL_PAGE})
			.applyFilters();
	}
	
	@Test
	public void pay_rate_card_contract_price() {
		SoftAssertions softly = new SoftAssertions();
		filterResults(MEDIUM_RATE_CARD_CONTRACT);
		exchangePage = new ExchangePageAdverteerder(driver);
		softly.assertThat(exchangePage.getTafiefPrice(MEDIUM_RATE_CARD_CONTRACT))
			.as("Exchange Page Tarief Price").isEqualTo("5.000,00");
		softly.assertThat(exchangePage.getFinalPrice(MEDIUM_RATE_CARD_CONTRACT))
			.as("Exchange Page Final Price").isEqualTo("1.875,00");

		PurchaseConfirmation purchaseConfirmation = exchangePage.purchaseMedium(MEDIUM_RATE_CARD_CONTRACT)
			.selectSeller(TestUser.UITGEVER_EEN);
		softly.assertThat(purchaseConfirmation.getBuyNowPrice())
			.as("Purchase Confirmation Buy Now Price").isEqualTo("11.000,00");
		softly.assertThat(purchaseConfirmation.getTariefPrice())
			.as("Purchase Confirmation Tarief Price").isEqualTo("10.000,00");		
		softly.assertThat(purchaseConfirmation.getFinalPrice())
			.as("Purchase Confirmation Final Price").isEqualTo("5.000,00");		
		
		OrderOverzichtTabAdverteerder orders = purchaseConfirmation.confirm()
		.openOrderoverzicht()
		.openOrders();
		
		softly.assertThat(orders.getPrice(MEDIUM_RATE_CARD_CONTRACT))
			.as("Order Page Paid Price").isEqualTo("5.000,00");	
		softly.assertAll();
	}
	
	
	@Test
	public void pay_rate_card_contract_price_with_volume_discount() {
		SoftAssertions softly = new SoftAssertions();

		filterResults(MEDIUM_RATE_CARD_CONTRACT);
		exchangePage = new ExchangePageAdverteerder(driver);
		softly.assertThat(exchangePage.getTafiefPrice(MEDIUM_RATE_CARD_CONTRACT))
			.as("Exchange Page Tarief Price").isEqualTo("5.000,00");
		softly.assertThat(exchangePage.getFinalPrice(MEDIUM_RATE_CARD_CONTRACT))
			.as("Exchange Page Final Price").isEqualTo("1.875,00");

		PurchaseConfirmation purchaseConfirmation = exchangePage.purchaseMedium(MEDIUM_RATE_CARD_CONTRACT)
			.selectSeller(TestUser.RESELLER_EEN);
		softly.assertThat(purchaseConfirmation.getBuyNowPrice())
			.as("Purchase Confirmation Buy Now Price").isEqualTo("5.500,00");
		softly.assertThat(purchaseConfirmation.getTariefPrice())
			.as("Purchase Confirmation Tarief Price").isEqualTo("5.000,00");		
		softly.assertThat(purchaseConfirmation.getFinalPrice())
			.as("Purchase Confirmation Final Price").isEqualTo("1.875,00");		
		
		OrderOverzichtTabAdverteerder orders = purchaseConfirmation.confirm()
			.openOrderoverzicht()
			.openOrders();
		
		softly.assertThat(orders.getPrice(MEDIUM_RATE_CARD_CONTRACT))
			.as("Order Page Paid Price").isEqualTo("1.875,00");	
		softly.assertAll();
	}
	
	
	@Test
	public void pay_rate_card_price_with_discount() {
		SoftAssertions softly = new SoftAssertions();

		filterResults(MEDIUM_BUY_NOW);
		exchangePage = new ExchangePageAdverteerder(driver);
		softly.assertThat(exchangePage.getTafiefPrice(MEDIUM_BUY_NOW))
			.as("Exchange Page Tarief Price").isEqualTo("5.000,00");
		softly.assertThat(exchangePage.getFinalPrice(MEDIUM_BUY_NOW))
			.as("Exchange Page Final Price").isEqualTo("4.125,00");

		PurchaseConfirmation purchaseConfirmation = exchangePage.purchaseMedium(MEDIUM_BUY_NOW)
			.selectSeller(TestUser.RESELLER_TWEE);
		softly.assertThat(purchaseConfirmation.getBuyNowPrice())
			.as("Purchase Confirmation Buy Now Price").isEqualTo("5.500,00");
		softly.assertThat(purchaseConfirmation.getTariefPrice())
			.as("Purchase Confirmation Tarief Price").isEqualTo("5.000,00");		
		softly.assertThat(purchaseConfirmation.getFinalPrice())
			.as("Purchase Confirmation Final Price").isEqualTo("4.125,00");		
		
		OrderOverzichtTabAdverteerder orders = purchaseConfirmation.confirm()
			.openOrderoverzicht()
			.openOrders();
		
		softly.assertThat(orders.getPrice(MEDIUM_BUY_NOW))
			.as("Order Page Paid Price").isEqualTo("4.125,00");	
		softly.assertAll();
	}
	
	
	
}
