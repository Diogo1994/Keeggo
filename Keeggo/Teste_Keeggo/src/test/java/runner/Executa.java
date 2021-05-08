package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "Features",
		glue = "steps",
		tags = "@executa",
		dryRun =  false,
		monochrome = true,
		plugin = {"pretty", "html:target/report.html"}
		
		)

public class Executa {

}
