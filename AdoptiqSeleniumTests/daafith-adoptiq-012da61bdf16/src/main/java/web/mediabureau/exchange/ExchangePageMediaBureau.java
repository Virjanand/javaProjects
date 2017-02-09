package web.mediabureau.exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExchangePageMediaBureau extends MediaBureauExchangeItem {
	
	@FindBy(css = ".int-adoptiq-bkg-color button")
	private WebElement wijzigButton;
	
	@FindBy(css = ".modal-dialog button[id^='mxui_widget_ActionButton']")
	private WebElement saveCampaignButton;
	
	@FindBy(css = ".mx-referenceselector-input-wrapper label")
	private WebElement selectedCampaignLabel;

	public ExchangePageMediaBureau(WebDriver driver) {
		super(driver);
	}

	private WebElement getTableRowForProduct(String productName) {
		return driver.findElement(By.xpath("//tbody[@class='mx-datagrid-body']/tr/td[4]/div[contains(text(), '"+productName+"')]"))
		.findElement(By.xpath("../.."));
	}
	
	public ExchangePageMediaBureau setCampaign(String campagne) {
		waitUtilities.waitAndClick(wijzigButton);
		waitUtilities.waitAndSelectByVisibleText(By.cssSelector(".modal-dialog select"), campagne);
		saveCampaignButton.click();
		return new ExchangePageMediaBureau(driver);
	}
	
	public String getSelectedCampaign() {
		return selectedCampaignLabel.getText();
	}
	
	public PurchaseConfirmation purchaseProduct(String productName) {
		waitUtilities.waitAndClick(
			getTableRowForProduct(productName)
			.findElement(By.xpath("td[contains(@class,'inlineButtonContainer')]/div/button[contains(text(), 'Koop nu')]")));
		return new PurchaseConfirmation(driver);
	}

}
