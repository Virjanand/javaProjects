package web.mediabureau;

import org.openqa.selenium.WebDriver;

import web.MijnAdoptiqPage;
import web.Page;
import web.mediabureau.exchange.ExchangePageMediaBureau;
import web.mediabureau.media.MediaPageMediaBureau;
import web.mediabureau.menus.TopMenuMediaBureau;

public class HomePageMediaBureau extends Page {

	private final TopMenuMediaBureau topMenuMediaBureau;
	
	public HomePageMediaBureau(WebDriver driver) {
		super(driver);
		topMenuMediaBureau = new TopMenuMediaBureau(driver);
	}

	public ExchangePageMediaBureau openExchangePage() {
		return topMenuMediaBureau.openExchangePage();
	}
	
	public MediaPageMediaBureau openMediaPage() {
		return topMenuMediaBureau.openMediaPage();
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		return topMenuMediaBureau.openMijnAdoptiqPage();
	}
	
}
