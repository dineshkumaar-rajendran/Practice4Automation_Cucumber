package AppHooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.org.dinesh.utility.configreader;

import DriverFactory.ThreadLocalDriver;
import DriverFactory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.enumer.ConfigProperties;
import qa.reports.ExtentReports_Test;

public class AppHooks {

	/*
	 * private Properties prop; private DriverFactoryManager Dfact; private
	 * ConfigReader configR; private WebDriver driver;
	 */

	@Before(order = 0)
	public void get_propert() {
		/*
		 * ConfigReader conf = new ConfigReader(); prop = conf.get_prop();
		 */
	}

	@Before(order = 1)
	public void Setup() throws Exception {

		driverFactory.init_driver(configreader.get(ConfigProperties.BROWSER));
		/*
		 * Dfact = new DriverFactoryManager(); String browsername
		 * =prop.getProperty("browser"); Dfact.init_drivers(browsername);
		 */
	}

	@After(order = 0)
	public void TearDown() throws IOException, Exception {
		driverFactory.QuitDriver();
		// Desktop.getDesktop().browse(new
		// File(FrameworkConstants.getExtentreportpath()).toURI());
		// Desktop.getDesktop().browse(new
		// File(FrameworkConstants.getSparktreportpath()).toURI());
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) ThreadLocalDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}

	}

}
