package web.mediabureau.exchange;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import web.AdoptiqTestScenario;
import web.LoginFactory;
import web.mediabureau.HomePageMediaBureau;

@Test
public class PricingTest extends AdoptiqTestScenario {

	private static final String CAMPAIGN_NAME = "reclame";
	private ExchangePageMediaBureau exchangePageMediaBureau;
	private HomePageMediaBureau homePageMediaBureau;
	
	@BeforeClass(alwaysRun=true)
	public void loginAsMediaBureau(){
		homePageMediaBureau = LoginFactory.loginAsMediaBureau(driver);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void openExchange() {
		exchangePageMediaBureau = homePageMediaBureau
				.openExchangePage();
	}
	
	public void shouldDisplayCampaign() {
		exchangePageMediaBureau.setCampaign(CAMPAIGN_NAME);
		assertThat(exchangePageMediaBureau.getSelectedCampaign(), equalTo(CAMPAIGN_NAME));
	}
	
	public void shouldDisplayPrice() {
		exchangePageMediaBureau.setCampaign(CAMPAIGN_NAME)
			.purchaseProduct("CD102VS - Advertentiepagina");
	}
	
}
