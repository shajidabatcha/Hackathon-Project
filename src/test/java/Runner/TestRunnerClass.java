package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // test runner should use cucumber to execute the tests
@CucumberOptions(
		
		features = {".//Features/"}, //features = {".//Features/"}: Specifies the directory where your feature files (.feature files) are located.
		//features = {"@target/rerun.txt"},
		glue={"StepDefinition"}, //Specifies the package or directory where your step definition classes are located.
		//plugin for cucumber report
		plugin= {"pretty","html:reports/myreport.html",
				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
		}
		)

public class TestRunnerClass {

	
}
