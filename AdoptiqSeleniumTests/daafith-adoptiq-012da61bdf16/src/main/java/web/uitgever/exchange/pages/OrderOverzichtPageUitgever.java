package web.uitgever.exchange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.uitgever.exchange.UitgeverExchangeItem;
import web.uitgever.exchange.tabs.OrderOverzichtTabUitgever;

public class OrderOverzichtPageUitgever extends UitgeverExchangeItem {

	@FindBy(css = ".mx-name-tabPage1")
	private WebElement ordersTab;
	
	public OrderOverzichtPageUitgever(WebDriver driver) {
		super(driver);
	}
	
	public OrderOverzichtTabUitgever openOrders() {
		ordersTab.click();
		return new OrderOverzichtTabUitgever(driver);
	}

}