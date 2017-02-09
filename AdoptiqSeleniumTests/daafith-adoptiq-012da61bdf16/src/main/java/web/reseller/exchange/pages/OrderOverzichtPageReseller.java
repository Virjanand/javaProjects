package web.reseller.exchange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.reseller.exchange.ResellerExchangeItem;
import web.reseller.exchange.tabs.OrderOverzichtTabReseller;

public class OrderOverzichtPageReseller extends ResellerExchangeItem {

	@FindBy(css = ".mx-name-tabPage1")
	private WebElement ordersTab;
	
	public OrderOverzichtPageReseller(WebDriver driver) {
		super(driver);
	}
	
	public OrderOverzichtTabReseller openOrders() {
		ordersTab.click();
		return new OrderOverzichtTabReseller(driver);
	}
}