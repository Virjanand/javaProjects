package web.uitgever.media;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;
import web.uitgever.media.tabs.MediumTab;
import web.uitgever.media.tabs.NieuwMediumTab;

public class MediaPageUitgever extends Page {
	
	@FindBy(css = ".mx-grid-toolbar button")
	private List<WebElement> actionButtons;
	
	@FindBy(css = ".mx-name-microflowButton2")
	private WebElement nieuwButton;
	
	@FindBy(css = ".mx-datagrid-body-table tr")
	private List<WebElement> mediaTableRows;

	public MediaPageUitgever(WebDriver driver) {
		super(driver);
	}
		
	public MediumTab createNewMedia() {
		waitUtilities.waitAndClick(nieuwButton);
		return new NieuwMediumTab(driver).openMediumTab();
	}
	
	/**
	 *  
	 * @param mediaTitle the media we want to know the properties of
	 * @return all non-empty properties of the media
	 */
	public List<String> getMediaProperties(String mediaTitle){
		List<String> mediaProperties = new ArrayList<>();
		final int actief = 5;

		List<WebElement> tableData = driver.findElement
				(By.xpath("//table[contains(@class, 'mx-datagrid-body')]/tbody/tr/td[2]/div[contains(text(), '"+mediaTitle+"')]"))
				.findElement(By.xpath("../.."))
				.findElements(By.tagName("td"));
		
		tableData.
			stream()
			.filter(data->data.getText().length() >= 1)
			.forEach(data->mediaProperties.add(data.findElement(By.tagName("div")).getText()));
		mediaProperties.add(tableData.get(actief).getAttribute("title"));
		return mediaProperties;
	}
	
	public MediumTab openMedia(String mediaTitle) {
		WebElement media = driver.findElement(By.xpath("//table[contains(@class, 'mx-datagrid-body')]/tbody/tr/td[2]/div[contains(text(), '"+mediaTitle+"')]"));
		actions.doubleClick(media);
		return new MediumTab(driver);
	}
	
//.mx-datagrid-body-table td div // all rows data div
	// .mx-datagrid-body-table td // all rows data
	
//	public void hoverOverInfo
	
//	.mx-datagrid-body tr td.mx-name-column3 div // all names
	//mx-name-column1 //codes
	//mx-name-column6 // on hover
	//mx-name-column4 // actief (title= ja || nee)
	//.//td[contains(@class, 'mx-name-column3')]/div[contains(text(), 'Polteq01')] find by name

}
