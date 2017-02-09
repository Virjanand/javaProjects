package web.adverteerder;

import org.testng.annotations.Test;

import web.browsersession.TestConfiguration;
import web.utils.FormattedPrice;

public class Testje {

	@Test public void sjdjd() {
		TestConfiguration.setConfiguration("", "Firefox", "EN");
		System.out.println(new FormattedPrice("50,000.00").getPrice());
	}

}
