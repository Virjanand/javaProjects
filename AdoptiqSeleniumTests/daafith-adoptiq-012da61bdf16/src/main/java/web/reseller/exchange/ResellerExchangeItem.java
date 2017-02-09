package web.reseller.exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import web.Page;
import web.reseller.exchange.pages.OrderOverzichtPageReseller;

/**
 * Makes switching between left menu items easy.
 */
public class ResellerExchangeItem extends Page {

	public ResellerExchangeItem(WebDriver driver) {
		super(driver);
	}
	//TODO: make menu items language independent
	public void openUitgeverDashboard() {
		openLeftMenuItem("Uitgever Dashboard");
	}
	
	public void openOptieOverzicht() {
		openLeftMenuItem("Optie overzicht");
	}
	
	public OrderOverzichtPageReseller openOrderoverzicht() {
		openLeftMenuItem("Orderoverzicht");
		return new OrderOverzichtPageReseller(driver);
	}
	
	public void openMediaBureaus() {
		openLeftMenuItem("Mediabureaus");
	}

	public void openAdverteerders() {
		openLeftMenuItem("Adverteerders");
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
