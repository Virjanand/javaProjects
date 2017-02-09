package web.uitgever.exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import web.Page;
import web.uitgever.exchange.pages.OrderOverzichtPageUitgever;

/**
 * Makes switching between left menu items easy.
 */
public class UitgeverExchangeItem extends Page {

	public UitgeverExchangeItem(WebDriver driver) {
		super(driver);
	}
	//TODO: make menu items language independent

	public void openUitgeverDashboard() {
		openLeftMenuItem("Uitgever Dashboard");
	}
	
	public void openOptieOverzicht() {
		openLeftMenuItem("Optie overzicht");
	}
	
	public OrderOverzichtPageUitgever openOrderoverzicht() {
		openLeftMenuItem("Orderoverzicht");
		return new OrderOverzichtPageUitgever(driver);
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
