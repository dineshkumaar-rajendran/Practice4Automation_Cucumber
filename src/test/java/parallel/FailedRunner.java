package parallel;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "@target/failedRerun.txt", glue = { "parallel",
"AppHooks" }, plugin = { "pretty", "rerun:target/failedRerun.txt" })
public class FailedRunner {

}
