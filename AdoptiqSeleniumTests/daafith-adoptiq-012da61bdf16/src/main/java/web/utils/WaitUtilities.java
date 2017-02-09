package web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	private final WebDriver driver;
	
	public WaitUtilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitTillElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mx-progress-indicator")));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitTillElementIsVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitAndClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mx-progress-indicator")));
		wait.until(ExpectedConditions.elementToBeClickable(element))
			.click();
	}
	
	public void waitAndClick(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mx-progress-indicator")));
		wait.until(ExpectedConditions.elementToBeClickable(by))
			.click();
	}
	
	public void waitAndSendKeys(WebElement element, String keys) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		element.sendKeys(keys);
	}

	public void waitAndSelectByVisibleText(By cssSelector, String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mx-progress-indicator")));
		new Select
			(wait.until(ExpectedConditions.elementToBeClickable(cssSelector)))
			.selectByVisibleText(visibleText);
		
	}
	
}
