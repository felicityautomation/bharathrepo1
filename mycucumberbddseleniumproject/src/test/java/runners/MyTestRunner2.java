package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"features/DemoBlazeLoginwithDataDriven.feature"},
glue = {"step.defination"},
plugin = {"html:htmlreport/cucumber-test-report.html","pretty","json:target/cucumber-report.json"}
		)
public class MyTestRunner2 extends AbstractTestNGCucumberTests {

}
