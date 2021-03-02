package DriverFactory;

import org.openqa.selenium.WebDriver;

public final class ThreadLocale {

	private static ThreadLocal<WebDriver> dr = new ThreadLocal();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver drref) {
		dr.set(drref);
	}

	public static void Unload() {
		dr.remove();
	}

}
