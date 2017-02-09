package web.adverteerder.exchange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.adverteerder.exchange.AdverteerderExchangeItem;
import web.adverteerder.exchange.tabs.ArchiefOverzichtTabAdverteerder;
import web.adverteerder.exchange.tabs.OrderOverzichtTabAdverteerder;

public class OrderOverZichtPageAdverteerder extends AdverteerderExchangeItem {

	@FindBy(css = ".mx-name-tabPage1")
	private WebElement ordersTab;
	
	@FindBy(css = ".mx-name-tabPage2")
	private WebElement archiefTab;
	
	public OrderOverZichtPageAdverteerder(WebDriver driver) {
		super(driver);
	}
	
	public OrderOverzichtTabAdverteerder openOrders() {
		ordersTab.click();
		return new OrderOverzichtTabAdverteerder(driver);
	}
	
	public ArchiefOverzichtTabAdverteerder openArchief() {
		archiefTab.click();
		return new ArchiefOverzichtTabAdverteerder(driver);
	}

}
