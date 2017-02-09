package web.reseller;

import org.openqa.selenium.WebDriver;

import web.MijnAdoptiqPage;
import web.Page;
import web.reseller.exchange.ResellerExchangeItem;
import web.reseller.media.MediaPageReseller;
import web.reseller.menus.TopMenuReseller;

public class HomePageReseller extends Page {

	private final TopMenuReseller topMenu;
	
	public HomePageReseller(WebDriver driver) {
		super(driver);
		topMenu = new TopMenuReseller(driver);
	}
	
	public MediaPageReseller openMediaPage() {
		return topMenu.openMediaPage();
	}
	
	public ResellerExchangeItem openExchangePage() {
		return topMenu.openExchangePage();
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		return topMenu.openMijnAdoptiqPage();
	}

}
