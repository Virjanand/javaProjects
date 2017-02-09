package web.browsersession;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyEventListener implements WebDriverEventListener {

	private static final Logger LOG = Logger.getLogger(WebDriverEventListener.class.getName());


	public void afterChangeValueOf(WebElement driver, WebDriver arg1) {
		// No need for implementation yet
	}


	public void afterClickOn(WebElement element, WebDriver driver) {
		// No need for implementation yet
	}


	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// No need for implementation yet
	}


	public void afterNavigateBack(WebDriver arg0) {
		// No need for implementation yet
	}


	public void afterNavigateForward(WebDriver arg0) {
		// No need for implementation yet
	}


	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// No need for implementation yet
	}


	public void afterScript(String arg0, WebDriver arg1) {
		// No need for implementation yet
	}


	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 2px solid red;");
		} catch (WebDriverException wde) {
			LOG.info("Driver cannot highlight element. Could be a browser version issue.");
		} 	
	}


	public void beforeClickOn(WebElement element, WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 2px solid red;");
		} catch (WebDriverException wde) {
			LOG.info("Driver cannot highlight element. Could be a browser version issue.");
		} 
	}


	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// No need for implementation yet
	}


	public void beforeNavigateBack(WebDriver arg0) {
		// No need for implementation yet
	}


	public void beforeNavigateForward(WebDriver arg0) {
		// No need for implementation yet
	}


	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// No need for implementation yet
	}


	public void beforeScript(String arg0, WebDriver arg1) {
		// No need for implementation yet
	}


	public void onException(Throwable throwable, WebDriver driver) {
		// No need for implementation yet
	}

}
