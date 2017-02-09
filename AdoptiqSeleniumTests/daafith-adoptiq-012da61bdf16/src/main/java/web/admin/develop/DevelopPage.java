package web.admin.develop;

import org.openqa.selenium.WebDriver;

import web.Page;
import web.admin.develop.menus.DevelopLeftMenu;

public class DevelopPage extends Page {

	private final DevelopLeftMenu developLeftMenu;
	
	public DevelopPage(WebDriver driver) {
		super(driver);
		developLeftMenu = new DevelopLeftMenu(driver);
	}
	
	public UnitTestPage openUnitTestsPage() {
		return developLeftMenu.openUnitTests();
	}

}
