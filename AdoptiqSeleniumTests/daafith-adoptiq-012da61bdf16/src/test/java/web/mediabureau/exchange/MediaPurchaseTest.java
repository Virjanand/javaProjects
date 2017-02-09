package web.mediabureau.exchange;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import web.AdoptiqTestScenario;
import web.LoginFactory;

@Test
public class MediaPurchaseTest extends AdoptiqTestScenario {
	
	@BeforeClass(alwaysRun = true)
	public void login() {
		LoginFactory.loginAsMediaBureau(driver)
			.openExchangePage();
	}
	
	@Test
	public void someThing() {
		
	}

}
