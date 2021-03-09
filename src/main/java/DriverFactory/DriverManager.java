package DriverFactory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.org.dinesh.constants.FrameworkConstants;
import com.org.dinesh.utility.configreader;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.enumer.ConfigProperties;

public final class DriverManager {
	private DriverManager() {
		// TODO Auto-generated constructor stub
	}

	public static WebDriver getDriver(String browserName) throws Exception {
		WebDriver driver = null;
		String runMode = configreader.get(ConfigProperties.RUNMODE);

		if (browserName.equalsIgnoreCase("chrome")) {
			if (runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {

			if (runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
		} else if (browserName.equalsIgnoreCase("edge")) {
			if (runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.EDGE);
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

				System.setProperty("webdriver.edge.driver", FrameworkConstants.getEdgedriverpath());
				driver = new EdgeDriver();

			}
		} else {
			System.out.println("Please enter valid Browser Name to run the test cases");
		}
		return driver;
	}
}
