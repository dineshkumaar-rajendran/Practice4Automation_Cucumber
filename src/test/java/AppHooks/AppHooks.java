package AppHooks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.org.dinesh.constants.FrameworkConstants;
import com.org.dinesh.utility.configreader;

import DriverFactory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.enumer.ConfigProperties;
import qa.reports.ExtentLogger;
import qa.reports.ExtentManager;
import qa.reports.ExtentReports_Test;



public class AppHooks {

	protected Scenario scenario;
	static String ScenarioName;
	/*
	 * private Properties prop; private DriverFactoryManager Dfact; private
	 * ConfigReader configR; private WebDriver driver;
	 */

	
	
	
	@Before(order = 0)
	public void get_Scenariot(Scenario scenario) throws Exception {
		ExtentReports_Test.init_reports();
		this.scenario = scenario;
		ScenarioName = scenario.getName();
		ExtentReports_Test.createTest(ScenarioName);
		ExtentManager.getExtentTest().log(Status.INFO,"Scenario started : "+scenario.getName());
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
	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			
			ExtentLogger.fail(ScenarioName,true);
			// take screenshot:
			/*
			 * String screenshotName = scenario.getName().replaceAll(" ", "_"); byte[]
			 * sourcePath = ((TakesScreenshot)
			 * ThreadLocalDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
			 * scenario.attach(sourcePath, "image/png", screenshotName);
			 */

		} else {
			ExtentLogger.pass(ScenarioName,true);
		}
		ExtentReports_Test.Flush_reports();
		//Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI());
	}
	
	

}
