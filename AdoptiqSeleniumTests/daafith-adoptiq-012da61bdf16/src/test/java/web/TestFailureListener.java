package web;

import java.io.File;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class TestFailureListener extends TestListenerAdapter {

	private static final Logger LOG = Logger.getLogger(WebDriverEventListener.class.getName());

    @Override
    public void onTestFailure(ITestResult result) {
        final Object currentClass = result.getInstance();
        try {
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            final WebDriver webDriver = ((AdoptiqTestScenario) currentClass).driver;
            final File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            final String fileName = result.getName() + UUID.randomUUID();
            final File targetFile = new File("target/screenshots/" + fileName + ".png");
            FileUtils.copyFile(screenshotFile, targetFile);
            result.setAttribute("screenshot", "<a target='blank' href='../screenshots/" + fileName
                    + ".png'>Screenshot</a>");
            Reporter.setCurrentTestResult(result);
            Reporter.log("<a target='blank' href='" + targetFile.getAbsolutePath() + "'> Screenshot</a>\n");
        } catch (final Exception e) {
        	LOG.info(e.getSuppressed().toString());
        }
    }
}
