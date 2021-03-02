package AppHooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import ConfigReader.ConfigReader;
import DriverFactory.DriverFactoryManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AppHooks {
	
	private Properties prop;
	private DriverFactoryManager Dfact;
	private ConfigReader configR;
	private WebDriver driver;
	
	@Before(order = 0)
	public void get_propert() {
		ConfigReader conf = new ConfigReader();
		prop = conf.get_prop();
	}

	@Before(order = 1)
	public void Setup() throws Exception {
		Dfact = new DriverFactoryManager();
		String browsername =prop.getProperty("browser");
		Dfact.init_drivers(browsername);
	}

	@After
	public void TearDown() {
		DriverFactoryManager.closeBrowser();
	}

}
