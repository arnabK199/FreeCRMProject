package com.ak.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	
	public static ExtentReports getInstance(String Filename) {
		
		htmlReporter = new ExtentHtmlReporter("./target/Reports/"+Filename);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Arnab's Extent Report");
		htmlReporter.config().setDocumentTitle("Extent Report 4.0");
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Automation Tester", "Arnab Kundu");
		report.setSystemInfo("Orgainzation", "Way2Automation");
		report.setSystemInfo("Build No", "W2A-1234");
        
        
        return report;
	}

}
