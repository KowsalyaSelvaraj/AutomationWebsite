package com.project.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtentSparkReporter reporter = new ExtentSparkReporter("./Report/TestResult.html");

		ExtentReports extentReports = new ExtentReports();

		extentReports.attachReporter(reporter);

		ExtentTest test = extentReports.createTest("TC_001 - Search Product");

		test.pass("Go to search Product option");
		test.pass("Apply filter");
		test.pass("Search the desierd Product ", MediaEntityBuilder.createScreenCaptureFromPath("./Report/Screenshots/Screenshot1.PNG")
				.build());
		extentReports.flush();
		System.out.println("hello");
	}

}
