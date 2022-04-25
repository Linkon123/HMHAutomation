package StepDefinition.WebsiteLaunchNavigationURLValidationSD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome= true,
		//dryRun=true,
		
		features= {"src/test/resources/Features/"},
		glue= {"StepDefinition/WebsiteLaunchNavigationURLValidationSD"},
		
		plugin= {"pretty",
				"html:target/cucumber-htmlreport.html",
				"json:target/cucumber-report1.json",
				
		} 
		
		
		)

public class RunValidationTest {


	
}
