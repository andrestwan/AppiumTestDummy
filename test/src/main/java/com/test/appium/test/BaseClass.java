package com.test.appium.test;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.read.biff.BiffException;

public class BaseClass extends Report {

static AppiumDriver<WebElement> driver;
	
	@BeforeTest
	public static void BaseClass() throws BiffException, IOException {
    DesiredCapabilities caps = new DesiredCapabilities();
		
    
		String platform = "android";
		
		if (platform.equalsIgnoreCase("android")){
			
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "andre");
			caps.setCapability("appPackage", "silktest.insurancemobile");
			caps.setCapability("appActivity", "silktest.insurancemobile.LoginActivity");
		} else if(platform.equalsIgnoreCase("iOS")) {
			
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
			caps.setCapability("appPackage", "silktest.insurancemobile");
			caps.setCapability("appActivity", "silktest.insurancemobile.LoginActivity");
			
		}
		
			
		
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<WebElement>(url, caps);
	}
	
	@Test
	public void testapp() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("Test Started Application");
	}
	
	
	@AfterTest
	public void teatDown() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
}
