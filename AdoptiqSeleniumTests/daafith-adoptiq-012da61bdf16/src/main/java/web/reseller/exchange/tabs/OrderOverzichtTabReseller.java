package web.reseller.exchange.tabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;
import web.utils.FormattedPrice;

public class OrderOverzichtTabReseller extends Page {

	@FindBy(css = ".table-striped tr")
	public List<WebElement> resultRows;
	 
	//.//tr/td[contains(@class, 'mx-name-column4')]/div  zoeken op medium  ../..
	// .//tr/td[contains(@class, 'mx-name-column1')]/div zoeken op editie 
	// .//tr/td[contains(@class, 'mx-name-column8')]/div zoeken op product 
	// .//tr/td[@class = 'mx-name-column9 mx-left-aligned']/div zoeken op mediabureau
	// .//tr/td[contains(@class, 'mx-name-column61')]/div zoeken op adverteerder
	//.//tr/td[@class = 'mx-name-column3 mx-right-aligned']/div prijs
	// .//tr/td[contains(@class, 'mx-name-column38')]/div zoeken op contract
	private By tariefPriceTextField = By.cssSelector(".mx-name-column3 div");
	private By buyerTextField = By.cssSelector(".mx-name-column61 div");

	
	public OrderOverzichtTabReseller(WebDriver driver) {
		super(driver);
	}
	
	public String getPrice(String mediumName) {
		WebElement tariefPrice = getTableRowForMedium(mediumName)
			.findElement(tariefPriceTextField);
		return new FormattedPrice(tariefPrice.getText()).getPrice();
	}
	
	public String getBuyer(String mediumName) {
		WebElement tariefPrice = getTableRowForMedium(mediumName)
			.findElement(buyerTextField);
		return tariefPrice.getText();
	}

	private WebElement getTableRowForMedium(String mediumName) {
		return driver.findElement(By.xpath("//tr/td/div[text()='"+mediumName+"']"))
			.findElement(By.xpath("../.."));
	}

}
