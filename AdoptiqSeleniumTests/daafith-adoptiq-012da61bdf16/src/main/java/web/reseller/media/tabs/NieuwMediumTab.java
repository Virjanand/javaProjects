package web.reseller.media.tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;

/**
 * @author David
 * Makes switching between tabs easy when creating new medium. 
 */
public class NieuwMediumTab extends Page {

	@FindBy(css = ".mx-name-tabPage7")
	private WebElement mediumTabLink;
	
	@FindBy(css = ".mx-name-tabPage2")
	private WebElement publicatieTemplatesTabLink;
	
	public NieuwMediumTab(WebDriver driver) {
		super(driver);
	}

	public MediumTab openMediumTab() {
		waitUtilities.waitAndClick(mediumTabLink);
		return new MediumTab(driver);
	}
	
	public PublicatieTemplateTab openPublicatieTemplates() {
		publicatieTemplatesTabLink.click();
		return new PublicatieTemplateTab(driver);
	}
	
}
