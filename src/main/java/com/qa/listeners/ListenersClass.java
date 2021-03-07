package com.qa.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import qa.reports.ExtentLogger;
import qa.reports.ExtentReports_Test;

public class ListenersClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReports_Test.init_reports();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReports_Test.Flush_reports();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReports_Test.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			
			String message = result.getMethod().getMethodName()+ " is Passed";
			ExtentLogger.pass(message ,true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String message = result.getMethod().getMethodName()+ " is Failed";
			ExtentLogger.fail(message, true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			String message = result.getMethod().getMethodName()+ " is Skipped";
			ExtentLogger.skip(message);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
