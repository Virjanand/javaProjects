package web.admin.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import web.Menu;
import web.admin.develop.DevelopPage;

public class TopMenuAdmin extends Menu {

	//TODO: make items language independent
	@FindBy(xpath = "//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Develop')]")
	private WebElement developLink;

	public TopMenuAdmin(WebDriver driver) {
		super(driver);
	}
	
	public DevelopPage openDevelopPage() {
		waitUtilities.waitAndClick(developLink);
		return new DevelopPage(driver);
	}
	
}
