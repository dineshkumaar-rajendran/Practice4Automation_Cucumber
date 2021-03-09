package com.qa.listeners;

import org.testng.*;

import io.cucumber.java.Scenario;
import qa.reports.ExtentLogger;
import utility.MyRetryAnalyzer;
import utility.RetryLogic;

import java.util.*;

public class MyTestListenerAdapter extends TestListenerAdapter {
	protected Scenario scenario;
	static String ScenarioName;

	public void ScenarioEnabler() {
		this.scenario = scenario;
		ScenarioName = scenario.getName();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Sucesss");
		try {

			String message = result.getMethod().getMethodName() + " is Passed";
			ExtentLogger.pass(message, true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Failure");
		try {
			String message = result.getMethod().getMethodName()+ " is Failed";
			ExtentLogger.fail(message, true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Skipped");
		try {
			String message = result.getMethod().getMethodName()+ " is Skipped";
			ExtentLogger.skip(message);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	
}


public static void unusedcode() {
	/*
	 * if (result.getMethod().getRetryAnalyzer() != null) { MyRetryAnalyzer
	 * retryAnalyzer = (MyRetryAnalyzer) result.getMethod().getRetryAnalyzer();
	 * 
	 * if (retryAnalyzer.isRetryAvailable()) { try { ExtentLogger.skip(ScenarioName
	 * + " is Failed", true); } catch (Exception e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } } else { try { ExtentLogger.skip(ScenarioName +
	 * " is Failed", true); } catch (Exception e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } } Reporter.setCurrentTestResult(result); } }
	 * 
	 * Iterator<ITestResult> failedTestCases =
	 * context.getFailedTests().getAllResults().iterator(); while
	 * (failedTestCases.hasNext()) { System.out.println("failedTestCases");
	 * ITestResult failedTestCase = failedTestCases.next(); ITestNGMethod method =
	 * failedTestCase.getMethod(); if
	 * (context.getFailedTests().getResults(method).size() > 1) {
	 * System.out.println("failed test case remove as dup:" +
	 * failedTestCase.getTestClass().toString()); failedTestCases.remove(); } else {
	 * 
	 * if (context.getPassedTests().getResults(method).size() > 0) {
	 * System.out.println( "failed test case remove as pass retry:" +
	 * failedTestCase.getTestClass().toString()); failedTestCases.remove(); } }
	 */
}

}