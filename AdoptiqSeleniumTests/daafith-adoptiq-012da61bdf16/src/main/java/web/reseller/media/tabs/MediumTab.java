package web.reseller.media.tabs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import web.uitgever.media.MediaPageUitgever;

public class MediumTab extends NieuwMediumTab {

	private static final int OMSCHRIJVING_TEXTFIELD = 4;

	private static final int SAMENSTELLING_SELECT = 3;

	private static final int TYPE_SELECT = 2;

	private static final int NAAM_TEXTFIELD = 1;

	private static final int CODE_TEXTFIELD = 0;

	private static final int OPSLAAN_BUTTON = 1;

//	@FindBy(css = ".mx-name-textBox3 .form-control")
//	private WebElement codeTextField;
//	
//	@FindBy(css = ".mx-name-textBox4 .form-control") //#mxui_widget_TextInput_3 .form-control
//	private WebElement naamTextField;
//	
//	@FindBy(css = ".mx-name-dropDown3 .form-control")
//	private WebElement typeSelect;
//	
//	@FindBy(css = ".mx-name-dropDown4 .form-control")
//	private WebElement samenstellingSelect;
	
	@FindBy(css = ".form-control")
	private List<WebElement> formInputs;
	
	@FindBy(css = ".mx-dataview-controls button")
	private List<WebElement> actionButtons;

	@FindBy(css = ".mx-name-textBox3 input")
	private WebElement codeTextField;
	
	public MediumTab(WebDriver driver) {
		super(driver);
	}

	//TODO: is het niet beter om toch op basis van visible text te selecteren?
	/**
	 * 
	 * @param code
	 * @param name
	 * @param type Newspaper || Newspaper_regional || Newspaper_local || Newspaper_DoorToDoor || Magazine || Magazine_Professional || Other
	 * @param samenstelling Title || TitleEdition || Edition 
	 */
	public MediumTab fillInMandatoryFields(String code, String name, String type, String samenstelling) {
		waitUtilities.waitAndSendKeys(formInputs.get(CODE_TEXTFIELD), code);
		formInputs.get(NAAM_TEXTFIELD).sendKeys(name);
		new Select(formInputs.get(TYPE_SELECT)).selectByValue(type);
		new Select(formInputs.get(SAMENSTELLING_SELECT)).selectByValue(samenstelling);
		return this;
	}
	
	public MediumTab setCode(String code) {
		waitUtilities.waitAndSendKeys(codeTextField, code);
		return this;
	}
	
	public MediumTab setNaam(String name) {
		waitUtilities.waitAndSendKeys(formInputs.get(NAAM_TEXTFIELD), name);
		return this;
	}

	
	public MediumTab setOmschrijving(String omschrijving) {
		waitUtilities.waitAndSendKeys(formInputs.get(OMSCHRIJVING_TEXTFIELD), omschrijving);
		return this;
	}
	
	public MediaPageUitgever save() {
		actionButtons.get(OPSLAAN_BUTTON).click();
		return new MediaPageUitgever(driver);
	}

}
