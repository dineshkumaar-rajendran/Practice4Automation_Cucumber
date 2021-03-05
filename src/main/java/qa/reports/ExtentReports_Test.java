package qa.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.org.dinesh.constants.FrameworkConstants;

public final class ExtentReports_Test {

	private ExtentReports_Test() {

	}

	private static ExtentReports extent;
	private static ExtentSparkReporter spark;

	public static void init_reports() throws Exception {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation for Orange HRM");
			spark.config().setReportName("Selenium Automation");

		}
	}

	public static void Flush_reports() throws Exception {
		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentManager.unload();
			
		}
	}

	public static void createTest(String TestCaseName) {
		ExtentTest Test = extent.createTest(TestCaseName);
		ExtentManager.setExtent(Test);
	}

}
