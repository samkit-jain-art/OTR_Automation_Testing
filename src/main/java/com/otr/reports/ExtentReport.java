package com.otr.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.otr.constants.FrameworkConstants;

import java.util.Objects;

public class ExtentReport {
   private static ExtentReports extentReports;


    public static void initReports() {
        if (Objects.isNull(ExtentManager.getExtentTest())){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("OTR_Mobile_Automation");
        sparkReporter.config().setDocumentTitle("OTR");
        extentReports.attachReporter(sparkReporter);
        }
    }

    public static void tearDownReport() {
        if (Objects.nonNull(ExtentManager.getExtentTest())){
        extentReports.flush();
        ExtentManager.unLoad();
        }
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
    }
}
