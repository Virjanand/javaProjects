package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

//TODO: should perhaps go in different class
	private By confirmationButton = By.cssSelector(".mx-dataview-controls .mx-name-microflowButton2");
	private By confirmPasswordTextField = By.cssSelector(".mx-name-textBox1 input");
	private By newPasswordTextField = By.cssSelector(".mx-name-textBox3 input");
	private By oldPasswordTextField = By.cssSelector(".mx-name-textBox5 input");

	@FindBy(id = "usernameInput")
	private WebElement usernameTextField;
	
	@FindBy(id = "passwordInput")
	private WebElement passwordTextField;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginWith(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		waitUtilities.waitTillElementIsVisible(oldPasswordTextField).sendKeys(oldPassword);
		driver.findElement(newPasswordTextField).sendKeys(newPassword);
		driver.findElement(confirmPasswordTextField).sendKeys(newPassword);
		driver.findElement(confirmationButton).click();
	}

}
