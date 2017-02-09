package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import web.utils.WaitUtilities;

/** 
 * A Menu is ubiquitous (like the top menu) and should be part the users Home Page{@link Page}. <br />
 *
 */
public abstract class Menu {

	protected final WebDriver driver;
	protected final WaitUtilities waitUtilities;
	
	public Menu(WebDriver driver) {
		this.driver = driver;
		waitUtilities = new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
	}
}
