package web.browsersession;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriverSession {

	private WebDriverSession() {

	}

	public static EventFiringWebDriver start() {

		EventFiringWebDriver webDriver = null;
		DesiredCapabilities capability = new DesiredCapabilities();

		if (Browser.CHROME.equals(TestConfiguration.getBrowser())) {
			ChromeEventListener eventListener = new ChromeEventListener();
			capability = DesiredCapabilities.chrome();
			capability.setCapability("chrome.switches", "--verbose");
			ChromeDriverManager.getInstance().setup();
			webDriver = new EventFiringWebDriver(new ChromeDriver(capability)).register(eventListener);
		} else if (Browser.FIREFOX.equals(TestConfiguration.getBrowser())) {
			MyEventListener eventListener = new MyEventListener();
			capability = DesiredCapabilities.firefox();
			webDriver = new EventFiringWebDriver(new FirefoxDriver(capability)).register(eventListener);
		}

		return webDriver;
	}

}
