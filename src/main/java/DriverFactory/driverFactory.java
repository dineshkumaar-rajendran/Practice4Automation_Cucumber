package DriverFactory;



import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.org.dinesh.constants.FrameworkConstants;
import com.org.dinesh.utility.configreader;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.enumer.ConfigProperties;

public final class driverFactory {

	private driverFactory() {

	}

	public static void init_driver(String browserName) throws Exception {
		if (Objects.isNull(ThreadLocalDriver.getDriver())) {

			if (browserName.equalsIgnoreCase("chrome")) {
				// System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromepath());
				WebDriverManager.chromedriver().setup();
				ThreadLocalDriver.setDriver(new ChromeDriver());
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				ThreadLocalDriver.setDriver(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgedriverpath());
				ThreadLocalDriver.setDriver(new EdgeDriver());
			} else {
				System.out.println("Please enter valid Browser Name to run the test cases");
			}

			ThreadLocalDriver.getDriver().manage().window().maximize();
			ThreadLocalDriver.getDriver().get(configreader.get(ConfigProperties.URL));
		}
	}

	public static void QuitDriver() {
		if (Objects.nonNull(ThreadLocalDriver.getDriver())) {
			ThreadLocalDriver.getDriver().quit();
			ThreadLocalDriver.unload();
		}
	}

}
