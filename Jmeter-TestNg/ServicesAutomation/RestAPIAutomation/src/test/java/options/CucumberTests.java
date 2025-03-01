package options;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", overviewReport = true, outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-report", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
		"junit:target/cucumber-results.xml" }, features = { "./src/test/features" }, glue = { "stepdefs" })
public class CucumberTests {
}
