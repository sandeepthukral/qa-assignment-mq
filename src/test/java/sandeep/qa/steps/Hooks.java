package sandeep.qa.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.Vector;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.fail;

public class Hooks {

    private Context context;

    public Hooks(Context context){
        this.context = context;
    }

    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "build/surefire-reports";
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
    @After
    public void tearDown(Scenario scenario) {
        // take and attach screenshot if the scenario has failed
        if (scenario.isFailed()){
            WebDriver driver = getWebDriver();
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png", "Failure Screenshot");
        }

        // execute cleanups
        context.laterExecution.performCleanups();

//        Commented out, not required now unless it is decided there should be no JS errors in the execution
//        checkForSevereJSErrors();

        // close the webdriver
        closeWebDriver();
    }

    /**
     * Fail the test if a Severe JS Error is logged in the console
     * We can extend this to add a list of errors to skip
     */
    private void checkForSevereJSErrors() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Vector<String> errors = new Vector<String>();

        for (LogEntry entry : logEntries) {
            if (entry.getLevel().equals(Level.SEVERE)){
                errors.add(entry.getMessage());
            }
        }

        if (!errors.isEmpty()) {
            String message = "";
            for (String error: errors){
                message = message + " " + error;
            }
            fail(message);
        }
    }
}

