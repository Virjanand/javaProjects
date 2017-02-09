package web.adverteerder.media;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;

public class MediaPageAdverteerder extends Page {

	@FindBy(css = ".form-control")
	private WebElement searchTextField;
	
	@FindBy(css = ".btn.mx-button.mx-name-microflowButton11.btn-default")
	private WebElement searchButton;
	
	
	public MediaPageAdverteerder(WebDriver driver) {
		super(driver);
	}
	
	public MediaPageAdverteerder searchFor(String keyWord) {
		waitUtilities.waitAndSendKeys(searchTextField, keyWord);
		searchButton.click();
		return new MediaPageAdverteerder(driver);
	}
	
	

}
