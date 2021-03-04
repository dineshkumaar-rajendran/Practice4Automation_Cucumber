package qa.reports;



import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	private ExtentManager() {
		
	}

	private static ThreadLocal<ExtentTest> dr = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		return dr.get();
	}

	static void setExtent(ExtentTest Test) {
		dr.set(Test);
	}

	static void unload() {
		dr.remove();
	}
}
