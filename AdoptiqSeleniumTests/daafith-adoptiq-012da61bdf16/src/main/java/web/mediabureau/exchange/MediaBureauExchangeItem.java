package web.mediabureau.exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import web.Page;

public class MediaBureauExchangeItem extends Page {

	public MediaBureauExchangeItem(WebDriver driver) {
		super(driver);
	}
	//TODO: make menu items language independent
	public ExchangePageMediaBureau openExchangePage() {
		openLeftMenuItem("Exchange");
		return new ExchangePageMediaBureau(driver);
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
	
	public void openOrderoverzicht() {
		openLeftMenuItem("Orderoverzicht");
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
		driver.findElement
				(By.xpath("//li[contains(@class,'mx-navigationlist')]/label[contains(text(), '"+menuItemName+"')]"))
				.click();
	}
	
	private boolean isPageAlreadyDisplayed(String menuItemName) {
		return driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase(menuItemName); 
	}

}
