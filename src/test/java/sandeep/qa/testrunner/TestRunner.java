package sandeep.qa.testrunner;

import com.codeborne.selenide.junit.ScreenShooter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sandeep/qa/features",
        glue = "sandeep.qa.steps",
        plugin = {"pretty", "de.monochromata.cucumber.report.PrettyReports:build/test-reports/cucumber"},
        strict = true
)
public class TestRunner {
    @Rule
    public ScreenShooter makeScreenshotOnEveryTest = ScreenShooter.failedTests().succeededTests();
}