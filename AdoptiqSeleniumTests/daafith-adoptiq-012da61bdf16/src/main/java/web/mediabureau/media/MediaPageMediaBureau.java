package web.mediabureau.media;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;

public class MediaPageMediaBureau extends Page {

	@FindBy(css = ".form-control")
	private WebElement searchTextField;
	
	@FindBy(css = ".btn.mx-button.mx-name-microflowButton11.btn-default")
	private WebElement searchButton;
	
	
	public MediaPageMediaBureau(WebDriver driver) {
		super(driver);
	}
	
	public MediaPageMediaBureau searchFor(String keyWord) {
		waitUtilities.waitAndSendKeys(searchTextField, keyWord);
		searchButton.click();
		return new MediaPageMediaBureau(driver);
	}
	
	

}
