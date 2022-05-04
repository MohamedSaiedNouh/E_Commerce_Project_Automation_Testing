package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src\\main\\resources\\features",
        glue     = "StepDefinitions",
        plugin = { "pretty",
        "html:target/cucumber.html",
        "json:target/cucumber.json",
        "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        dryRun = false,
        tags     = "@RegressionTesting"
)
public class TestRunner {
}
