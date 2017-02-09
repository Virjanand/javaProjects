package web.adverteerder.exchange.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import web.Page;
import web.utils.FormattedPrice;

public class PurchaseConfirmation extends Page {

	@FindBy(css = ".mx-name-referenceSelector3 select")
	private WebElement sellerSelect;
	
	@FindBy(css = ".mx-name-checkBox1>input")
	private WebElement privateCheckbox;
	
	@FindBy(css = ".mx-dataview-controls button.btn-primary")
	private WebElement confirmButton;
	
	@FindBy(css = ".mx-dataview-controls button.btn-default")
	private WebElement cancelButton;
	
	@FindBy(css = ".mx-name-textBox4>label")
	private WebElement buyNowPriceTextField;
	
	@FindBy(css = ".mx-name-textBox14 > label")
	private WebElement tariefPriceTextField;

	@FindBy(css = ".mx-name-dvInventory .mx-name-textBox28>label")
	private WebElement finalPriceTextField;
	
	public PurchaseConfirmation(WebDriver driver) {
		super(driver);
	}
	
	public PurchaseConfirmation selectSeller(String sellerName) {
		new Select(sellerSelect).selectByVisibleText(sellerName);
		return this;
	}
	
//	public PurchaseConfirmation selectContractType(String contractType) {
//		if (!privateCheckbox.isSelected()) {
//			privateCheckbox.click();
//		}
//		// do stuff
//		return new PurchaseConfirmation(driver);
//	}
	
	
	public String getBuyNowPrice() {
		return new FormattedPrice(buyNowPriceTextField.getText()).getPrice();
	}
	
	public String getTariefPrice() {
		return new FormattedPrice(tariefPriceTextField.getText()).getPrice();
	}
	
	public String getFinalPrice() {
		waitUtilities.waitTillElementIsVisible(finalPriceTextField);
		return new FormattedPrice(finalPriceTextField.getText()).getPrice();
	}
	
	public ExchangePageAdverteerder confirm() {
		confirmButton.click();
		return new ExchangePageAdverteerder(driver);
	}
	
	public ExchangePageAdverteerder cancel() {
		cancelButton.click();
		return new ExchangePageAdverteerder(driver);
	}
}
