package com.test.appium.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	
	ExtentSparkReporter spark ;
	ExtentReports extent =new ExtentReports();
	
	
	@BeforeSuite
	public String reportSetup(){
		
	//	String path = "${workspace_project_locations}/HasilResultTest.html";
		String path = "target/Result/HasilResultTest.html";
		spark = new ExtentSparkReporter(path);
		extent.attachReporter(spark);
		
		spark.config().setDocumentTitle("ReportTest");
		spark.config().setReportName("Suite Reports");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		
		return path;
	}
	
	@AfterSuite
	public void reportTearDown(){
	
		extent.flush();
	}

}
