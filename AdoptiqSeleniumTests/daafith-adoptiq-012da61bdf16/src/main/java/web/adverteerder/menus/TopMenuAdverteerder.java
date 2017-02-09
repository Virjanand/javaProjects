package web.adverteerder.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Menu;
import web.MijnAdoptiqPage;
import web.adverteerder.exchange.AdverteerderExchangeItem;
import web.adverteerder.exchange.pages.ExchangePageAdverteerder;
import web.adverteerder.media.MediaPageAdverteerder;

public class TopMenuAdverteerder extends Menu {

	//TODO: make items language independent
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Exchange')]")
	private WebElement exchangeLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Media')]")
	private WebElement mediaLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Mijn Adoptiq')]")
	private WebElement mijnAdoptiqLink;
	
	public TopMenuAdverteerder(WebDriver driver) {
		super(driver);
	}
	
	public ExchangePageAdverteerder openExchangePage() {
		waitUtilities.waitAndClick(exchangeLink);
		return new AdverteerderExchangeItem(driver).openExchangePage();
	}
	
	public MediaPageAdverteerder openMediaPage() {
		waitUtilities.waitAndClick(mediaLink);
		return new MediaPageAdverteerder(driver);
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		waitUtilities.waitAndClick(mijnAdoptiqLink);
		return new MijnAdoptiqPage(driver);
	}
	

}
