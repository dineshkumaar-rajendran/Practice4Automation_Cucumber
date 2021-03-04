package qa.reports;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.org.dinesh.utility.configreader;

import DriverFactory.ThreadLocalDriver;
import qa.enumer.ConfigProperties;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String Message) {
		ExtentManager.getExtentTest().pass(Message);
	}
	
	public static void logInfo(String Message) {
		ExtentManager.getExtentTest().info(Message);
	}

	public static void fail(String Message) {
		ExtentManager.getExtentTest().fail(Message);
	}

	public static void skip(String Message) {
		ExtentManager.getExtentTest().skip(Message);
	}

	public static void pass(String Message, boolean IsScreenShotNeeded) throws Exception {
		if (configreader.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && IsScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(Message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			pass(Message);
		}
	}

	public static void fail(String Message, boolean IsScreenShotNeeded) throws Exception {
		if (configreader.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && IsScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(Message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			fail(Message);
		}
	}

	public static void skip(String Message, boolean IsScreenShotNeeded) throws Exception {
		if (configreader.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && IsScreenShotNeeded) {
			ExtentManager.getExtentTest().skip(Message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			skip(Message);
		}
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) ThreadLocalDriver.getDriver()).getScreenshotAs(OutputType.BASE64);

	}

}
