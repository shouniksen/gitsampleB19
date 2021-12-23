package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//test//resources//features//OpenCartMenu.feature",
		glue = {"stepDefs"},
		monochrome = true,
		publish = true,
		dryRun = false,
		plugin = {"pretty",
					"html:target/reports/htmlReport.html",
					"rerun:target/failed_scenarios.txt"
				}
		)

public class OpenCartRunner {

}
