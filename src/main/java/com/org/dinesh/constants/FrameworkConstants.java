package com.org.dinesh.constants;

import com.org.dinesh.utility.configreader;

import qa.enumer.ConfigProperties;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String PathToRes = "./src/test/resources/";
	private static final String ChromeDriverPath = PathToRes + "drivers/chromedriver.exe";
	private static final String EdgeDriverPath = PathToRes + "drivers/msedgedriver.exe";
	private static final String ConfigurationFilePath = PathToRes + "configuration/config.properties";
	private static final int ExWaitTime = 20;
	private static final String ExtentReportPath = System.getProperty("user.dir") + "/extent-test-output/";
	private static final String SparkReportPath = "C:\\Users\\625730\\Eclipse\\BDD\\Practice4Automation_Cucumber\\test-output\\SparkReport\\Index.html";

	public static String getSparkreportpath() {
		return SparkReportPath;
	}

	public static String getSparktreportpath() throws Exception {
		if (sparkReportsFilePath.isEmpty()) {
			sparkReportsFilePath = createSparkReportPath();
		}

		return extentReportsFilePath;
	}

	public static String extentReportsFilePath = "";
	public static String sparkReportsFilePath = "";

	public static String getEdgedriverpath() {
		return EdgeDriverPath;
	}

	public static int getExwaittime() {
		return ExWaitTime;
	}

	public static String getChromepath() {
		return ChromeDriverPath;
	}

	public static String getConfigFilePath() {
		return ConfigurationFilePath;
	}

	public static String getExtentreportpath() throws Exception {
		if (extentReportsFilePath.isEmpty()) {
			extentReportsFilePath = createReportPath();
		}

		return extentReportsFilePath;
	}

	private static String createReportPath() throws Exception {
		if (configreader.get(ConfigProperties.OVERRIDE).equalsIgnoreCase("no")) {
			return ExtentReportPath + System.currentTimeMillis() + "/index.html";
		} else {
			return ExtentReportPath + "index.html";
		}
	}

	private static String createSparkReportPath() throws Exception {
		if (configreader.get(ConfigProperties.OVERRIDE).equalsIgnoreCase("no")) {
			return SparkReportPath + System.currentTimeMillis() + "/index.html";
		} else {
			return SparkReportPath + "index.html";
		}
	}

}
