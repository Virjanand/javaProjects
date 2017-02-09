package web.adverteerder.exchange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.adverteerder.exchange.AdverteerderExchangeItem;
import web.utils.FormattedPrice;

public class ExchangePageAdverteerder extends AdverteerderExchangeItem {
	
	//TODO: make items language independent
	public enum Filter {
		MEDIUM("Medium"),
		FORMAAT_CODE("Formaatcode");
		
		private final String filterName;
		
		private Filter(String filterName) {
			this.filterName = filterName;
		}
		
		@Override
		public String toString() {
			return filterName;
		}
	}
	
	@FindBy(css = "button.mx-name-microflowButton8")
	private WebElement uitvoerenButton;
	
	@FindBy(css = ".int-adoptiq-bkg-color button")
	private WebElement wijzigButton;
	
	@FindBy(css = ".modal-dialog button[id^='mxui_widget_ActionButton']")
	private WebElement saveCampaignButton;
	
	@FindBy(css = ".mx-referenceselector-input-wrapper label")
	private WebElement selectedCampaignLabel;

	private By tariefPriceTextField = By.xpath("//tbody[@class='mx-datagrid-body']/tr/td[5]/div");

	private By finalPriceTextField = By.xpath("//tbody[@class='mx-datagrid-body']/tr/td[6]/div");

	public ExchangePageAdverteerder(WebDriver driver) {
		super(driver);
	}
	
	public ExchangePageAdverteerder selectFilterOptions(Filter filter, String[] filterOptions) {
		WebElement filterTableRow = driver.findElement
				(By.xpath(".//tr[not(contains(@style, 'none'))]/th/label[text()='"+filter.toString()+"']/../.."));
		filterTableRow.findElement(By.tagName("button")).click();
		for (String filterOption : filterOptions) {
			filterTableRow.findElements(By.cssSelector("li label"))
			.stream()
			.filter(option->option.getText().equals(filterOption))
			.forEach(option->option.findElement(By.tagName("input")).click());
		}
		filterTableRow.findElement(By.tagName("button")).click();
		return this;
	}
	
	public ExchangePageAdverteerder applyFilters() {
		uitvoerenButton.click();
		return new ExchangePageAdverteerder(driver);
	}
	
	public ExchangePageAdverteerder setCampaign(String campagne) {
		waitUtilities.waitAndClick(wijzigButton);
		waitUtilities.waitAndSelectByVisibleText(By.cssSelector(".modal-dialog select"), campagne);
		saveCampaignButton.click();
		return new ExchangePageAdverteerder(driver);
	}
	
	public String getSelectedCampaign() {
		return selectedCampaignLabel.getText();
	}
	
	private WebElement getTableRowForProduct(String productName) {
		return driver.findElement(By.xpath("//tbody[@class='mx-datagrid-body']/tr/td/div[contains(text(), '"+productName+"')]"))
				.findElement(By.xpath("../.."));
	}
	
	private WebElement getTableRowForMedium(String mediumName) {
		return driver.findElement(By.xpath("//tbody[@class='mx-datagrid-body']/tr/td/div[contains(text(), '"+mediumName+",')]"))
				.findElement(By.xpath("../.."));
	}
	
	//TODO: make items language independent
	public PurchaseConfirmation purchaseMedium(String mediumName) {
		waitUtilities.waitAndClick(
			getTableRowForMedium(mediumName)
				.findElement(By.xpath("td[contains(@class,'inlineButtonContainer')]/div/button[contains(text(), 'Koop nu')]")));
		return new PurchaseConfirmation(driver);
	}
	//TODO: make items language independent
	public PurchaseConfirmation placeBidForMedium(String mediumName) {
		waitUtilities.waitAndClick(
			getTableRowForMedium(mediumName)
			.findElement(By.xpath("td[contains(@class,'inlineButtonContainer')]/div/button[contains(text(), 'Bied')]")));
		return new PurchaseConfirmation(driver);
	}
	
	//TODO: make items language independent
	public PurchaseConfirmation purchaseProduct(String productName) {
		waitUtilities.waitAndClick(
			getTableRowForProduct(productName)
			.findElement(By.xpath("td[contains(@class,'inlineButtonContainer')]/div/button[contains(text(), 'Koop nu')]")));
		return new PurchaseConfirmation(driver);
	}

	public String getTafiefPrice(String mediumName) {
		WebElement tariefPrice = getTableRowForMedium(mediumName)
			.findElement(tariefPriceTextField);
		return new FormattedPrice(tariefPrice.getText()).getPrice();
	}
	
	public String getFinalPrice(String mediumName) {
		WebElement finalPrice = getTableRowForMedium(mediumName)
			.findElement(finalPriceTextField);
		return new FormattedPrice(finalPrice.getText()).getPrice();
	}

}
