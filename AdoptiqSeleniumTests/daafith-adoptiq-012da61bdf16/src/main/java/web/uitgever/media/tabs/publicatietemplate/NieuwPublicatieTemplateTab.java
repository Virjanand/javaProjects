package web.uitgever.media.tabs.publicatietemplate;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testutils.DateToday;
import web.Page;

public class NieuwPublicatieTemplateTab extends Page {
	
	private static final int FREQUENCY = 4;

	private static final int DATE_TO_SELECT = 3;

	private static final int DATE_FROM_SELECT = 2;

	private static final int SOORT_SELECT = 1;

	private static final int NAAM_TEXTFIELD = 0;

	@FindBy(css = "#mxui_widget_TextInput_9 input")
	private WebElement naamTextField;
	
	@FindBy(css = "#mxui_widget_EnumSelect_8 select")
	private WebElement soortSelect;
	
	@FindBy(css = "#mxui_widget_DateInput_6 .form-control.mx-dateinput-input")
	private WebElement fromDateSelect;
	
	@FindBy(css = "#mxui_widget_DateInput_7 .form-control.mx-dateinput-input")
	private WebElement toDateSelect;
	
	@FindBy(css = ".modal-content.mx-window-content .form-control")
	private List<WebElement> mandatoryInputFields;
	
	@FindBy(css = "tr ul.nav.nav-tabs.mx-tabcontainer-tabs")
	private WebElement tabList;
	
	//
	//to date
	//#mxui_widget_EnumSelect_9 select
	// frequentie
		
	public NieuwPublicatieTemplateTab(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Valid for all frequencies except <b>Wekelijks</b> and <b>Anders</b>
	 * @param name
	 * @param soort
	 * @param dateFrom
	 * @param dateTo
	 * @param frequency
	 * @return
	 */
	public NieuwPublicatieTemplateTab fillInMandatoryFields(String name, String soort, DateToday dateFrom, DateToday dateTo, String frequency) {
		waitUtilities.waitAndSendKeys(mandatoryInputFields.get(NAAM_TEXTFIELD), name);
		new Select(mandatoryInputFields.get(SOORT_SELECT)).selectByVisibleText(soort);
		mandatoryInputFields.get(DATE_FROM_SELECT).sendKeys(dateFrom.toString());
		mandatoryInputFields.get(DATE_TO_SELECT).sendKeys(dateTo.toString());
		new Select(mandatoryInputFields.get(FREQUENCY)).selectByVisibleText(frequency);
		return this;
	}
	
	/**
	 * Valid for frequency <b>Wekelijks</b>
	 * @param name
	 * @param soort
	 * @param dateFrom
	 * @param dateTo
	 * @param frequency
	 * @return
	 */
	public NieuwPublicatieTemplateTab fillInMandatoryFieldsWeeklyFrequency(String name, String soort, String dateFrom, String dateTo, String frequency) {
		waitUtilities.waitAndSendKeys(mandatoryInputFields.get(NAAM_TEXTFIELD), name);
		new Select(mandatoryInputFields.get(SOORT_SELECT)).selectByVisibleText(soort);
		mandatoryInputFields.get(DATE_FROM_SELECT).sendKeys(dateFrom);
		mandatoryInputFields.get(DATE_TO_SELECT).sendKeys(dateTo);
		new Select(mandatoryInputFields.get(FREQUENCY)).selectByVisibleText(frequency);
		return this;
	}
	
	/**
	 * Valid for frequency <b>Anders</b>
	 * @param name
	 * @param soort
	 * @param dateFrom
	 * @param dateTo
	 * @param frequency
	 * @return
	 */
	public NieuwPublicatieTemplateTab fillInMandatoryFieldsOtherFrequency(String name, String soort, String dateFrom, String dateTo, String frequency) {
		waitUtilities.waitAndSendKeys(mandatoryInputFields.get(NAAM_TEXTFIELD), name);
		new Select(mandatoryInputFields.get(SOORT_SELECT)).selectByVisibleText(soort);
		mandatoryInputFields.get(DATE_FROM_SELECT).sendKeys(dateFrom);
		mandatoryInputFields.get(DATE_TO_SELECT).sendKeys(dateTo);
		new Select(mandatoryInputFields.get(FREQUENCY)).selectByVisibleText(frequency);
		return this;
	}

}
