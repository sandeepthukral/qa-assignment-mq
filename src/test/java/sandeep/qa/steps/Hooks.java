package sandeep.qa.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {

    private Context context;

    public Hooks(Context context){
        this.context = context;
    }

    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "build/surefire-reports";
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

        // close the webdriver
        closeWebDriver();
    }
}

