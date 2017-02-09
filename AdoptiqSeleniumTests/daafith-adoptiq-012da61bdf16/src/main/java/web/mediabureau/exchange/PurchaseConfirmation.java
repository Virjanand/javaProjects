package web.mediabureau.exchange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import web.Page;

public class PurchaseConfirmation extends Page {

	@FindBy(css = ".mx-name-referenceSelector3 select")
	private WebElement sellerSelect;
	
	@FindBy(css = ".mx-name-checkBox1>input")
	private WebElement privateCheckbox;
	
	@FindBy(css = ".mx-dataview-controls button.btn-primary")
	private WebElement confirmButton;

	@FindBy(css = ".mx-name-textBox4>label")
	private WebElement buyNowPriceTextField;
	
	public PurchaseConfirmation(WebDriver driver) {
		super(driver);
	}
	
	public PurchaseConfirmation selectSeller(String sellerName) {
		new Select(sellerSelect).selectByVisibleText(sellerName);
		return this;
	}
	
	public PurchaseConfirmation selectContractType(String contractType) {
		if (!privateCheckbox.isSelected()) {
			privateCheckbox.click();
		}
		// do stuff
		return new PurchaseConfirmation(driver);
	}
	
	public String getBuyNowPrice() {
		return buyNowPriceTextField.getText();
	}

	public ExchangePageMediaBureau confirm() {
		confirmButton.click();
		return new ExchangePageMediaBureau(driver);
	}
}
