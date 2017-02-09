package web.admin;

import org.openqa.selenium.WebDriver;

import web.Page;
import web.admin.develop.DevelopPage;
import web.admin.menus.TopMenuAdmin;

public class HomePageAdmin extends Page {

	private final TopMenuAdmin topMenuAdmin;
	
	public HomePageAdmin(WebDriver driver) {
		super(driver);
		topMenuAdmin = new TopMenuAdmin(driver);
	}
	
	public DevelopPage openDevelopPage() {
		return topMenuAdmin.openDevelopPage();
	}
}
