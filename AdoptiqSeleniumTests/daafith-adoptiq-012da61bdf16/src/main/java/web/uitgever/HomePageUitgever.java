package web.uitgever;

import org.openqa.selenium.WebDriver;

import web.MijnAdoptiqPage;
import web.Page;
import web.uitgever.exchange.UitgeverExchangeItem;
import web.uitgever.media.MediaPageUitgever;
import web.uitgever.menus.TopMenuUitgever;

public class HomePageUitgever extends Page {

	private final TopMenuUitgever topMenu;
	
	public HomePageUitgever(WebDriver driver) {
		super(driver);
		topMenu = new TopMenuUitgever(driver);
	}
	
	public MediaPageUitgever openMediaPage() {
		return topMenu.openMediaPage();
	}
	
	public UitgeverExchangeItem openExchangePage() {
		return topMenu.openExchangePage();
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		return topMenu.openMijnAdoptiqPage();
	}

}
