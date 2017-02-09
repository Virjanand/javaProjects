package testutils;

import org.testng.Reporter;

/** 
 * For testing an debugging purposes
 */
public class TestLogger {

	
	/** 
	 * For testing an debugging purposes
	 */
	public static void printAndLog(String testInformation) {
		System.out.println(testInformation);
		Reporter.log(testInformation);	
	}
}
