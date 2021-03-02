package DriverFactory;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactoryManager {

	public void init_drivers(String browserName) throws Exception {

		if (Objects.isNull(ThreadLocale.getDriver())) {

			if (browserName.equalsIgnoreCase("chrome")) {
				// System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromepath());
				WebDriverManager.chromedriver().setup();
				ThreadLocale.setDriver(new ChromeDriver());
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				ThreadLocale.setDriver(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.chromedriver().setup();
				ThreadLocale.setDriver(new EdgeDriver());
			} else {
				System.out.println("Please enter valid Browser Name to run the test cases");
			}

			ThreadLocale.getDriver().manage().window().maximize();

		}
	}

	public static void closeBrowser() {
		if (Objects.nonNull(ThreadLocale.getDriver())) {
			ThreadLocale.getDriver().quit();
			ThreadLocale.Unload();
		}
	}

}
