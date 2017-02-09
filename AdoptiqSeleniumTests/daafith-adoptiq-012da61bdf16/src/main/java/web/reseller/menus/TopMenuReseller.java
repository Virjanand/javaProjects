package web.reseller.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Menu;
import web.MijnAdoptiqPage;
import web.reseller.exchange.ResellerExchangeItem;
import web.reseller.media.MediaPageReseller;

public class TopMenuReseller extends Menu {

	//TODO: make items language independent
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Exchange')]")
	private WebElement exchangeLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Media')]")
	private WebElement mediaLink;
	
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Mijn Adoptiq')]")
	private WebElement mijnAdoptiqLink;
	
	public TopMenuReseller(WebDriver driver) {
		super(driver);
	}
	
	public ResellerExchangeItem openExchangePage() {
		waitUtilities.waitAndClick(exchangeLink);
		return new ResellerExchangeItem(driver);
	}
	
	public MediaPageReseller openMediaPage() {
		waitUtilities.waitAndClick(mediaLink);
		return new MediaPageReseller(driver);
	}
	
	public MijnAdoptiqPage openMijnAdoptiqPage() {
		waitUtilities.waitAndClick(mijnAdoptiqLink);
		return new MijnAdoptiqPage(driver);
	}
	

}
