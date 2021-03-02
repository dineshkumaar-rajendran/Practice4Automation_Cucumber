package parallel;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/resources/parallel", glue = {
		"parallel", "AppHooks" }, plugin = { "pretty" })

public class RunCucumberTest {

}
