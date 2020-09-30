package com.test.appium.test;

import java.io.IOException;

import jxl.read.biff.BiffException;

public class Maintest {

	public static void main(String[] args) throws BiffException, InterruptedException, IOException {
		
		String path = "target/Result/HasilResultTest.html";
		//String path = "${workspace_project_locations}/HasilResultTest.html";
		
		BaseClass base = new BaseClass();
		Tests tes = new Tests();
		SendEmail maill = new SendEmail();
		Report pot = new Report();
		
		tes.BaseClass();
		tes.test1();
		
		tes.takeScreenshotAtEndOfTest();
		tes.reportSetup();
		//maill.sendEmailatt(path);
		
		//tes.sendEmailatt(path);
		
		
	}

}
