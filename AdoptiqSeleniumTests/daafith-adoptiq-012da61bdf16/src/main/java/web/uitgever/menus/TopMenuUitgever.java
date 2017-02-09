package web.uitgever.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Menu;
import web.MijnAdoptiqPage;
import web.uitgever.exchange.UitgeverExchangeItem;
import web.uitgever.media.MediaPageUitgever;

public class TopMenuUitgever extends Menu {

	//TODO: make items language independent
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Exchange')]")
	private WebElement exchangeLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Media')]")
	private WebElement mediaLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Mijn Adoptiq')]")
	private WebElement mijnAdoptiqLink;
	
	public TopMenuUitgever(WebDriver driver) {
		super(driver);
	}
	
	public UitgeverExchangeItem openExchangePage() {
		waitUtilities.waitAndClick(exchangeLink);
		return new UitgeverExchangeItem(driver);
	}
	
	public MediaPageUitgever openMediaPage() {
		waitUtilities.waitAndClick(mediaLink);
		return new MediaPageUitgever(driver);
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		waitUtilities.waitAndClick(mijnAdoptiqLink);
		return new MijnAdoptiqPage(driver);
	}
	

}
