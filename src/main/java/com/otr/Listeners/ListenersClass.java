package com.otr.Listeners;


import com.otr.reports.ExtentLogger;
import com.otr.reports.ExtentReport;
import org.testng.*;

public class ListenersClass implements ITestListener,ISuiteListener  {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+" is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName()+" is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName()+" is skipped");
    }





}
