package DriverFactory;

import java.util.Objects;

import com.org.dinesh.utility.configreader;

import qa.enumer.ConfigProperties;

public final class driverFactory {

	private driverFactory() {

	}

	public static void init_driver(String browserName) throws Exception {
		if (Objects.isNull(ThreadLocalDriver.getDriver())) {
			ThreadLocalDriver.setDriver(DriverManager.getDriver(browserName));
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
