package web.browsersession;

public class TestConfiguration {

	private static String url;
	private static Browser browser;
	private static Language language;


	private TestConfiguration(String url, String browser, String language) {
		TestConfiguration.url = url;
		TestConfiguration.browser = Browser.get(browser);
		TestConfiguration.language = Language.get(language);
	}
	
	public static TestConfiguration setConfiguration(String url, String browser, String language) {
		return new TestConfiguration(url, browser, language);
	}
	
	public static String getUrl() {
		return url;
	}
	
	public static Browser getBrowser() {
		return browser;
	}
	
	public static Language getLanguage() {
		return language;
	}

}
