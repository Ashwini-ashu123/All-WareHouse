package RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Featurefile",
        glue = {"StepDefnFile", "hooksClass"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        monochrome = true
)
public class runnerPage extends AbstractTestNGCucumberTests {
}
