package web.uitgever.media;

import org.testng.annotations.Test;

import testutils.DateToday;
import web.AdoptiqTestScenario;
import web.LoginFactory;

@Test
public class NieuwMediumTest extends AdoptiqTestScenario {
	
	public void nieuwMedium() {
		DateToday fromDate = new DateToday().plusMonths(3);
		DateToday toDate = new DateToday().plusMonths(6);
		
		MediaPageUitgever mediaPageUitgever = LoginFactory.loginAsUitgeverEen(driver)
			.openMediaPage();
		
		mediaPageUitgever
			.createNewMedia()
			.fillInMandatoryFields("Hello", "Hello World", "Newspaper", "Title")
			
			.openPublicatieTemplates()
			.createNewPublicatieTemplate()
			.fillInMandatoryFields("Test", "Algemeen", fromDate, toDate, "Dagelijks");
	}

}
