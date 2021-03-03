package DriverFactory;



import org.openqa.selenium.WebDriver;

public final class ThreadLocalDriver {
	
	private ThreadLocalDriver() {
		
	}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driveref) {
		dr.set(driveref);
	}

	public static void unload() {
		dr.remove();
	}
	
	
}
