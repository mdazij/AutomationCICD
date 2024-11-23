package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "MyProject.stepDefination", monochrome = true, tags = "@Regrassion", plugin = {
		"html:target/cucumber.html" })
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
