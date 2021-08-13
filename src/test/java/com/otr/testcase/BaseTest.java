package com.otr.testcase;

import com.otr.driver.Driver;
import com.otr.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class BaseTest {


    @BeforeSuite
    public void setUpSuite(){
        ExtentReport.initReports();
    }

    @AfterSuite
    public void tearDownSuite(){
        ExtentReport.tearDownReport();
    }
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();

    }
}
