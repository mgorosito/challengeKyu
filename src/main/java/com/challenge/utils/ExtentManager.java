package com.challenge.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    private static String reportFileName = "reports/challenge-report.html";

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
            return extent;
    }

    public static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(reportFileName));
        htmlReporter.config().setReportName("Challenge Report");
        htmlReporter.config().setDocumentTitle("Challenge Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
