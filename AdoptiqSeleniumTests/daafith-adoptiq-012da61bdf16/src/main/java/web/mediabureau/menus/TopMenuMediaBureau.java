package web.mediabureau.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Menu;
import web.MijnAdoptiqPage;
import web.mediabureau.exchange.ExchangePageMediaBureau;
import web.mediabureau.exchange.MediaBureauExchangeItem;
import web.mediabureau.media.MediaPageMediaBureau;

public class TopMenuMediaBureau extends Menu {

	//TODO: make items language independent
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Exchange')]")
	private WebElement exchangeLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Media')]")
	private WebElement mediaLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Mijn Adoptiq')]")
	private WebElement mijnAdoptiqLink;
	
	public TopMenuMediaBureau(WebDriver driver) {
		super(driver);
	}
	
	public ExchangePageMediaBureau openExchangePage() {
		waitUtilities.waitAndClick(exchangeLink);
		return new MediaBureauExchangeItem(driver).openExchangePage();
	}
	
	public MediaPageMediaBureau openMediaPage() {
		waitUtilities.waitAndClick(mediaLink);
		return new MediaPageMediaBureau(driver);
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		waitUtilities.waitAndClick(mijnAdoptiqLink);
		return new MijnAdoptiqPage(driver);
	}
	

}
