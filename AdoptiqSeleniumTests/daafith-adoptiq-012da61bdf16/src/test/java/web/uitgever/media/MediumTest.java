package web.uitgever.media;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testutils.Randomizer;
import web.AdoptiqTestScenario;
import web.LoginFactory;
import web.uitgever.media.MediaPageUitgever;
import web.uitgever.menus.TopMenuUitgever;

@Test
public class MediumTest extends AdoptiqTestScenario {
	
	private static final String SAMENSTELLING = "Title";
	private static final String TYPE = "Newspaper";
	private static final String CODE = "CODE" + Randomizer.getRandomNumber();
	private static final String UPDATED_CODE  = "CODE" + Randomizer.getRandomNumber();

	private MediaPageUitgever mediaPageUitgever; 
	private static final String NAME = "Name" + Randomizer.getRandomString();

	@BeforeClass(alwaysRun=true)
	public void loginAsUitgever() {
		LoginFactory.loginAsUitgeverEen(driver);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void goToHomePage() {
		mediaPageUitgever = new TopMenuUitgever(driver)
				.openMediaPage();
	}
	
	public void shouldCreateMedium() {
		mediaPageUitgever
			.createNewMedia()
			.fillInMandatoryFields(CODE, NAME, TYPE, SAMENSTELLING)
			.save();
		
		assertThat(mediaPageUitgever.getMediaProperties(NAME), hasItems("Losse titel", "Krant (Landelijk)", CODE, NAME, "Ja"));
	
	}
	
	public void shouldUpdateMedium() {
		String mediaTitle = "Namef001dc6a-21b7-4f6b-b1c0-633cd7478b4b";
		
		mediaPageUitgever.openMedia(mediaTitle)
			.setCode(UPDATED_CODE)
			.save();
		
		assertThat(mediaPageUitgever.getMediaProperties(mediaTitle), hasItem(UPDATED_CODE));
	}
		

}
