package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import web.utils.AdvancedInteractions;
import web.utils.WaitUtilities;

/**
 * A Page can contain it's own methods and it can be composed of </b>n</b> {@link Menu} classes. <br />
 *
 */
public abstract class Page {
	
	protected final WebDriver driver;
	protected final WaitUtilities waitUtilities;
	protected final AdvancedInteractions actions;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		waitUtilities = new WaitUtilities(driver);
		actions = new AdvancedInteractions(driver);
		PageFactory.initElements(driver, this);
	}

}
