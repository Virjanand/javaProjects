package testdata;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestUserProperty {
	
	public static String getTestUsernamePrefix() {
		return propertyValue("test.username.prefix");
	}

	public static String getPassWord() {
		return propertyValue("test.password");
	}
	
	private static String propertyValue(String propertyKey) {
		Properties properties = new Properties();
		try (InputStream inputStream = TestUserProperty.class.getResourceAsStream("/testsuite.properties")) {
			properties.load(inputStream);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return properties.getProperty(propertyKey);
	}

}
