package web.admin.develop.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import web.Menu;
import web.admin.develop.UnitTestPage;

public class DevelopLeftMenu extends Menu {

	public DevelopLeftMenu(WebDriver driver) {
		super(driver);
	}
	
	public UnitTestPage openUnitTests() {
		openLeftMenuItem("Unit tests");
		return new UnitTestPage(driver);
	}
	
	private void openLeftMenuItem(String menuItemName) {
		if (!isMenuOpened()) {
			driver.findElement(By.xpath("//li[contains(@class, 'mx-navbar-item')]/a[contains(text(), 'Develop')]")).click();
		} 
		driver.findElement
				(By.xpath("//li[contains(@class,'mx-navigationlist')]/label[contains(text(), '"+menuItemName+"')]"))
				.click();
	}

	private boolean isMenuOpened() {
		try {
			return driver.findElement(By.xpath("//li[contains(@class, 'mx-navigationlist-item')]/h2[contains(text(), 'Development')]")).isDisplayed();
		} catch (NoSuchElementException nsee) {
			return false;	
		}
	}

}
