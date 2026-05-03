package com.framework.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class Listeners implements ITestListener  {
	ExtentReports extent = ExtentManager.getReportObject();
	ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
    	ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
    	if (test.get() != null) {
            test.get().pass("Test Passed");
        }
    }

    public void onTestFailure(ITestResult result) {
    	if (test.get() != null) {
            test.get().fail(result.getThrowable());
        }
    }

    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }

}
