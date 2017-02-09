package web.adverteerder;

import org.openqa.selenium.WebDriver;

import web.MijnAdoptiqPage;
import web.Page;
import web.adverteerder.exchange.pages.ExchangePageAdverteerder;
import web.adverteerder.media.MediaPageAdverteerder;
import web.adverteerder.menus.TopMenuAdverteerder;

public class HomePageAdverteerder extends Page {

	private final TopMenuAdverteerder topMenuAdverteerder;
	
	public HomePageAdverteerder(WebDriver driver) {
		super(driver);
		topMenuAdverteerder = new TopMenuAdverteerder(driver);
	}

	public ExchangePageAdverteerder openExchangePage() {
		return topMenuAdverteerder.openExchangePage();
	}
	
	public MediaPageAdverteerder openMediaPage() {
		return topMenuAdverteerder.openMediaPage();
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		return topMenuAdverteerder.openMijnAdoptiqPage();
	}
	
}
