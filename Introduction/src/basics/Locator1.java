package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.findElement(By.id("email")).sendKeys("virjanand@hotmail.com");
		driver.findElement(By.name("pass")).sendKeys("pasteur");
		driver.findElement(By.id("u_0_w")).click();
	}

}
