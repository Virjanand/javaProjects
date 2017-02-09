package web.admin.develop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Page;

public class UnitTestPage extends Page {

	@FindBy(xpath = ".//div[@class='mx-name-textBox1']/label[contains(text(), 'Media')]")
	private WebElement mediaMenuItem;
	
	@FindBy(css = ".mx-name-microflowButton5")
	private WebElement enterNameButton;
	
	@FindBy(css = ".mx-name-textBox1 .form-control")
	private WebElement userNameTextField;
	
	@FindBy(css = ".mx-dataview-controls button")
	private WebElement saveButton;

	@FindBy(css = ".mx-name-textBox3 > label")
	private WebElement currentTestNameLabel;
	
	@FindBy(xpath = "//button[text() = 'Start unit test run']")
	private WebElement startUnitTestButton;
	
	public UnitTestPage(WebDriver driver) {
		super(driver);
	}
	
	public UnitTestPage startMediaTestsForUserName(String usernamePrefix) {
		mediaMenuItem.click();
		if (!currentTestNameLabel.getText().equals(usernamePrefix)) {
			enterNameButton.click();
			waitUtilities.waitAndSendKeys(userNameTextField, usernamePrefix);
			saveButton.click();
		}
//		System.out.println(startUnitTestButton.getAttribute("class") + " " + startUnitTestButton.getText());
		startUnitTestButton.click();
		return new UnitTestPage(driver);
	}

}
