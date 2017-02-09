package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://google.com");

		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://google.com");
		
	}

}
