package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.org.dinesh.utility.configreader;

import qa.enumer.ConfigProperties;

public class RetryLogic implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;
	boolean value;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if (configreader.get(ConfigProperties.RETRYTHETEST).equalsIgnoreCase("yes")) {
				value = count < retries;
				count++;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}
}