package web.reseller.media.tabs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;
import web.uitgever.media.tabs.publicatietemplate.NieuwPublicatieTemplateTab;

public class PublicatieTemplateTab extends Page {

	private static final int NIEUW_BUTTON = 2;

	@FindBy(css = ".mx-grid-toolbar button")
	private List<WebElement> actionButtons;
	
	public PublicatieTemplateTab(WebDriver driver) {
		super(driver);
	}
	
	public NieuwPublicatieTemplateTab createNewPublicatieTemplate() {
		waitUtilities.waitAndClick(actionButtons.get(NIEUW_BUTTON));
		return new NieuwPublicatieTemplateTab(driver);
	}

}
