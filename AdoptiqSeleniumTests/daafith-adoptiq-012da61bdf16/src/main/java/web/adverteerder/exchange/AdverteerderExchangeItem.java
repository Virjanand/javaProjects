package web.adverteerder.exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import web.Page;
import web.adverteerder.exchange.pages.ExchangePageAdverteerder;
import web.adverteerder.exchange.pages.OrderOverZichtPageAdverteerder;

public class AdverteerderExchangeItem extends Page {

	public AdverteerderExchangeItem(WebDriver driver) {
		super(driver);
	}
	//TODO: make menu items language independent
	public ExchangePageAdverteerder openExchangePage() {
		openLeftMenuItem("Exchange");
		return new ExchangePageAdverteerder(driver);
	}
	
	public void openWinkelmand() {
		openLeftMenuItem("Winkelmand");
	}

	public void openBiedingEnOrderOverzicht() {
		openLeftMenuItem("Bieding- en orderoverzicht");
	}
	
	public void openCampagneDashboard() {
		openLeftMenuItem("Campagne Dashboard");
	}
	
	public OrderOverZichtPageAdverteerder openOrderoverzicht() {
		openLeftMenuItem("Orderoverzicht");
		return new OrderOverZichtPageAdverteerder(driver);
	}
	
	public void openPlaatsingsSchema() {
		openLeftMenuItem("Plaatsingsschema");
	}
	
	public void openAdverteerders() {
		openLeftMenuItem("Adverteerders");
	}
	
	public void openCampagnes() {
		openLeftMenuItem("Campagnes");
	}
	
	public void openContracten() {
		openLeftMenuItem("Contracten");
	}
	
	private void openLeftMenuItem(String menuItemName) {
		if (isPageAlreadyDisplayed(menuItemName)) return;
		waitUtilities.waitAndClick(driver.findElement
				(By.xpath("//li[contains(@class,'mx-navigationlist')]/label[contains(text(), '"+menuItemName+"')]")));
	}

	private boolean isPageAlreadyDisplayed(String menuItemName) {
		return driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase(menuItemName); 
	}

}
