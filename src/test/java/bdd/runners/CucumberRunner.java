
package bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/bdd/features",
        glue = {"bdd.steps"},
        plugin = {"pretty","html:target/cucumber-report.html"},
        monochrome = true
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
