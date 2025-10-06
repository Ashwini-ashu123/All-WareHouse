package RunnerClass;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Featurefile",
        glue = {"StepDefnFile","hooksClass"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@SmokeTesting or @Bug"
)

public class runnerPage {

}

