package web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdvancedInteractions {

	private final Actions actions;
	
	public AdvancedInteractions(WebDriver driver) {
		actions = new Actions(driver);
	}
	
	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}
	
}
