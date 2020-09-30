package com.test.appium.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Tests extends BaseClass {
	
@Test(priority=1)
	
	public void test1() throws InterruptedException, IOException, BiffException {
	
		String path = "target/Result/HasilResultTest.html";
		SendEmail mail = new SendEmail();
		
		FileInputStream fi = new FileInputStream("target/Book1.xls");
		//FileInputStream fi = new FileInputStream("E:\\Appium\\Data\\Book1.xls");
		Workbook wrk = Workbook.getWorkbook(fi);
		Sheet wrksheet = wrk.getSheet(0);
		String a[][] = new String[wrksheet.getRows()][wrksheet.getColumns()];
		
		for (int rowCnt = 1; rowCnt<wrksheet.getRows(); rowCnt++) {
			
		ExtentTest Login = extent.createTest("Login", "Login Successfully");
		
		Login.log(Status.INFO, "Test starter");
		System.out.println("=======================================================================");
		System.out.println("Masuk Login");
		System.out.println("=======================================================================");
		
		 Thread.sleep(2000);
		 driver.findElementById("silktest.insurancemobile:id/email").click();  
		 driver.findElementById("silktest.insurancemobile:id/email").sendKeys(wrksheet.getCell(0, rowCnt).getContents());
		 
		 Login.log(Status.INFO, "Username Email 'john.smith@gmail.com'");
		 
		 System.out.println("Username Email");
		 
		 Login.log(Status.PASS, "Username is Validation and proper");
		 
		 Thread.sleep(1000);
		 driver.findElementById("silktest.insurancemobile:id/password").click();  
		 driver.findElementById("silktest.insurancemobile:id/password").sendKeys(wrksheet.getCell(1, rowCnt).getContents());
		 
		 Login.log(Status.INFO, "Password added 'john'");
		 
		 System.out.println("Password entered");
		 
		 Login.log(Status.PASS, "Password is validation and proper");
		 
		 driver.findElementById("silktest.insurancemobile:id/log_in_button").click();
		 
		 Login.log(Status.INFO, "Login button clicked and user is redirwcting to home page");
		 
		 System.out.println("Login Button clicked");
		 
		 Thread.sleep(1000);
		 
		 Login.log(Status.PASS, "Login button successfully clicked");
		 
		 Login.log(Status.PASS, "Login Successful");
		 
		 Thread.sleep(3000);
		 
		 System.out.println("=======================================================================");
		 System.out.println("Masuk Home");
		 System.out.println("=======================================================================");
		
		Login.log(Status.PASS, "Passed test 2"+Login.addScreenCaptureFromPath(takeScreenshotAtEndOfTest()));
		Login.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
	//	 login.pass(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
		 
		 
		 Thread.sleep(3000);
		 
		 //MENU
		 ExtentTest menu = extent.createTest("Menu", "Menu Successfully");
		 ExtentTest menu1 = menu.createNode("Menu Auto Quote");
		 ExtentTest menu2 = menu.createNode("Agent Lookup");
		 ExtentTest menu3 = menu.createNode("About");
		 ExtentTest menu4 = menu.createNode("Logout");
		 
		 
		 //Menu1
		 
		 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='drawer_open']")));	 
			WebElement drawer_open = driver.findElementByAccessibilityId("drawer_open");
			drawer_open.click();
			
			System.out.println("klik button HOME");
			/*menu1.log(Status.INFO, "Klik button HOME");
			menu2.log(Status.INFO, "Klik button HOME");
			menu3.log(Status.INFO, "Klik button HOME");*/
			
			
			driver.findElementById("silktest.insurancemobile:id/imageView").click();
		 
			Thread.sleep(3000);
			driver.findElementById("silktest.insurancemobile:id/autoquote_zip").click();
			driver.findElementById("silktest.insurancemobile:id/autoquote_zip").sendKeys(wrksheet.getCell(2, rowCnt).getContents());
			
			System.out.println("Add Zip Code");
			menu1.log(Status.INFO, "Zip Code added 12150");
			
			driver.findElementById("silktest.insurancemobile:id/radio_female").click();				//RadioButton
			System.out.println("Click Radio Button");
			menu1.log(Status.INFO, "Clik radio button Female");
			
			driver.findElementById("silktest.insurancemobile:id/rating_driving_record").click();
			
			//scrollVertical
			
			 driver.findElementById("silktest.insurancemobile:id/radio_female").click();
			 
			 org.openqa.selenium.Dimension dim = driver.manage().window().getSize();
			 int x= (int) (dim.getWidth()/2);
			 int startY = (int)(dim.getHeight() * 0.5);
			 int endY = (int)(dim.getHeight() * 0.2);
			 
			 TouchAction t = new TouchAction(driver);
			 t.press(PointOption.point(x, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x, endY)).release().perform();
			 
			 menu1.log(Status.INFO, "Scroll Screen");
			 
			 driver.findElementById("silktest.insurancemobile:id/rating_driving_record").isDisplayed();
			 
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/autoquote_car_year").click();
			 driver.findElementById("silktest.insurancemobile:id/autoquote_car_year").sendKeys(wrksheet.getCell(3, rowCnt).getContents());
			menu1.log(Status.INFO, "Set Year 2001");
			
			 driver.findElementById("silktest.insurancemobile:id/car_make").click();
			 Thread.sleep(2000);
			 driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]").click();
			 menu1.log(Status.INFO, "click make menu");
			 
			//SCROLL SCREEN 
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/rating_driving_record").click();
			 org.openqa.selenium.Dimension di = driver.manage().window().getSize();
			 int X= (int) (di.getWidth()/2);
			 int startYy = (int)(di.getHeight() * 0.5);
			 int endYy = (int)(di.getHeight() * 0.2);
			 
			 TouchAction T = new TouchAction(driver);
			 T.press(PointOption.point(X, startYy)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(X, endYy)).release().perform();
			 
			 driver.findElementById("silktest.insurancemobile:id/autoquote_car_year").isDisplayed();
			 menu1.log(Status.INFO, "Scroll screen");
			
			Thread.sleep(1000); 
			driver.findElementById("silktest.insurancemobile:id/car_model").click();
			Thread.sleep(1000);
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]").click();
			menu1.log(Status.INFO, "Click Model ");
			
			Thread.sleep(1000);
			driver.findElementById("silktest.insurancemobile:id/financial_info").click();
			Thread.sleep(2000);
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]").click();
			menu1.log(Status.INFO, "Click Financial info ");
			
			driver.findElementById("silktest.insurancemobile:id/submit").click();
			
			menu1.log(Status.INFO, "Submit button click");
			System.out.println("Click Menu Submit");
			menu1.log(Status.PASS, "Submit button click");
			
			Thread.sleep(2000);
			menu1.log(Status.PASS, "screenshot MENU1 "+menu1.addScreenCaptureFromPath(takeScreenshotAtEndOfTest()));
			menu1.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(5000);
			
			//BACK
			driver.navigate().back();
			driver.navigate().back();
			
			
			
			//MENU2 AgentLookup
			
			Thread.sleep(1000);
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='drawer_open']")));	 
			WebElement menu31 = driver.findElementByAccessibilityId("drawer_open");
			menu31.click();
			menu2.log(Status.INFO, "click Agent Lookup");
			
			driver.findElementById("silktest.insurancemobile:id/logged_in_as").click();
				//1
			Thread.sleep(1000);
			driver.findElementById("silktest.insurancemobile:id/agent_search_zip").click();
			driver.findElementById("silktest.insurancemobile:id/agent_search_zip").sendKeys(wrksheet.getCell(4, rowCnt).getContents());
			menu2.log(Status.INFO, "send zip code 12150");
			System.out.println("send by zip code 12150");
			
			driver.findElementById("silktest.insurancemobile:id/search_by_location_button").click();
			menu2.log(Status.INFO, "Send search by Location");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
				
				//back
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElementById("silktest.insurancemobile:id/agent_search_zip").clear();
			menu2.log(Status.INFO, "Clear data");
			
				//2
			Thread.sleep(1000);
			driver.findElementById("silktest.insurancemobile:id/agent_search_name").click();
			driver.findElementById("silktest.insurancemobile:id/agent_search_name").sendKeys(wrksheet.getCell(5, rowCnt).getContents());
			menu2.log(Status.INFO, "Send Name Andre Setiawan");
			System.out.println("send by search name Andre Setiawan");
			
			driver.findElementById("silktest.insurancemobile:id/search_by_name_button").click();
			menu2.log(Status.INFO, "Click search by Name");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
				//back
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElementById("silktest.insurancemobile:id/agent_search_name").clear();
			menu2.log(Status.INFO, "Clear data");
			
			
				//3
			driver.findElementById("silktest.insurancemobile:id/show_all_agents_button").click();
			menu2.log(Status.INFO, "click show all agents");
			
			//AgentFound 1
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]"))).click();
			menu2.log(Status.INFO, "click Agent Alice Walker");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
			driver.findElementById("silktest.insurancemobile:id/agent_details_close").click();
			menu2.log(Status.INFO, "close Agent");
			
			//AgentFound 2
			Thread.sleep(2000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))).click();
			menu2.log(Status.INFO, "click Agent Jim Taylor");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
			driver.findElementById("silktest.insurancemobile:id/agent_details_close").click();
			menu2.log(Status.INFO, "Close Agent");
			
			//AgentFound 3
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"))).click();
			menu2.log(Status.INFO, "Click Agent George Wilson");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
			driver.findElementById("silktest.insurancemobile:id/agent_details_close").click();
			menu2.log(Status.INFO, "Close Agent");
			
			//AgentFound 4
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]"))).click();
			menu2.log(Status.INFO, "Click Agent Williw Cameron");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
			driver.findElementById("silktest.insurancemobile:id/agent_details_close").click();
			menu2.log(Status.INFO, "Close Agent");
			
			//AgentFound 5
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]"))).click();
			menu2.log(Status.INFO, "Click Agent Al Borland");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
			driver.findElementById("silktest.insurancemobile:id/agent_details_close").click();
			menu2.log(Status.INFO, "Close Agent");
			
			//AgentFound 6
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]"))).click();
			menu2.log(Status.INFO, "Click Agent Dave Clayton");
			menu2.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			Thread.sleep(2000);
			
			driver.findElementById("silktest.insurancemobile:id/agent_details_close").click();
			menu2.log(Status.INFO, "Close Agent");
			
			Thread.sleep(2000);
			//Back
			driver.navigate().back();
			driver.navigate().back();
			
			
			//MENU ABOUT
			
			Thread.sleep(2000);
			 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='drawer_open']")));	 
			 WebElement open = driver.findElementByAccessibilityId("drawer_open");
			 open.click();
			
			 menu3.log(Status.INFO, "Button Menu About Click");
			 
			 //clik button dengan coordinate
			 Thread.sleep(2000);
			 TouchAction action = new TouchAction(driver);
			 action.tap(PointOption.point(111, 597)).perform();
			
			 //ScreenShot
			 Thread.sleep(2000);
			 menu3.log(Status.PASS, "screenshot MENU3 "+menu3.addScreenCaptureFromPath(takeScreenshotAtEndOfTest()));
			 menu3.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			 Thread.sleep(5000);
			 
			 System.out.println("show menu about success");
			 menu3.log(Status.PASS, "Show Menu About SuccesFullfy");
			 Thread.sleep(2000);
			 
			 //BACK
			 driver.navigate().back();
			 
			 
			 //LOGOUT
			 
			 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='drawer_open']")));	 
			 WebElement menu311 = driver.findElementByAccessibilityId("drawer_open");
			 menu311.click();
			
			 menu4.log(Status.INFO, "Button Logout Click");
			 System.out.println("CLick button Logout");
			 
			 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ImageView[1]"))).click();
			
			 menu4.log(Status.PASS, "Logout Succesfull");
			 
			 
			 //Agent Sign Up
			 
			//klikbutton
			 ExtentTest signup = extent.createTest("SignUp", "SignUp Successfully");
			 Thread.sleep(1000);
			 TouchAction act = new TouchAction(driver);
			 act.tap(PointOption.point(904, 1978)).perform();
			 
			 signup.log(Status.INFO, "Click button SignUp");
			 
			 System.out.println("=======================================================================");
			 System.out.println("SignUP");
			 System.out.println("=======================================================================");
			 System.out.println("klik Button SignUp");
			 //register
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/firstName").click();
			 driver.findElementById("silktest.insurancemobile:id/firstName").sendKeys(wrksheet.getCell(6, rowCnt).getContents());
			
			 signup.log(Status.INFO, "Send data Andre");
			 System.out.println("Send Nama FirstNama: Andre");
			 
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/lastName").click();
			 driver.findElementById("silktest.insurancemobile:id/lastName").sendKeys(wrksheet.getCell(7, rowCnt).getContents());
			 
			 signup.log(Status.INFO, "Send data Setiawan");
			 System.out.println("Send Nama LastName: Setiawan");
			 
			 //kalender
			 driver.findElementById("silktest.insurancemobile:id/birthday").click();
			 
			 signup.log(Status.INFO, "CLick Birthday");
			 System.out.println("Klik button Birthday");
			 
			 Thread.sleep(1000);
			 driver.findElementById("android:id/date_picker_header_year").click();
			 
			 driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.ScrollView/android.widget.ViewAnimator/android.widget.ListView/android.widget.TextView[3]").isDisplayed();
			 org.openqa.selenium.Dimension dri = driver.manage().window().getSize();
			 int Xx= (int) (dri.getWidth()/2);
			 int startYyy = (int)(dri.getHeight() * 0.5);
			 int endYyy = (int)(dri.getHeight() * 0.1);
			 
			 TouchAction To = new TouchAction(driver);
			 T.press(PointOption.point(Xx, startYyy)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(Xx, endYyy)).release().perform();
			 
			 Thread.sleep(1000);
			 driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.ScrollView/android.widget.ViewAnimator/android.widget.ListView/android.widget.TextView[6]").isDisplayed();
			 
			 Thread.sleep(1000);
			 driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.ScrollView/android.widget.ViewAnimator/android.widget.ListView/android.widget.TextView[6]").click();
		
			 Thread.sleep(1000);
			 TouchAction klik = new TouchAction(driver);
			 klik.tap(PointOption.point(542, 1411)).perform();
			 
			 Thread.sleep(1000);
			 driver.findElementById("android:id/button1").click();
			 signup.log(Status.INFO, "Click data Birthday");
			 
			 
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/email").click();
			 driver.findElementById("silktest.insurancemobile:id/email").sendKeys(wrksheet.getCell(8, rowCnt).getContents());
			 signup.log(Status.INFO, "Send data Email setiawan@gmail.com");
			 System.out.println("Send Data Email setiawan@gmail.com");
			 
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/password").click();
			 driver.findElementById("silktest.insurancemobile:id/password").sendKeys(wrksheet.getCell(9, rowCnt).getContents());
			 signup.log(Status.INFO, "Send Password *******");
			 System.out.println("Send Password ********");
			 
			 driver.findElementById("silktest.insurancemobile:id/sign_up_button").click();
			 signup.log(Status.INFO, "CLick signUP");
			 signup.log(Status.PASS, "Succesfully Sign Up");
			// signup.pass((MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAtEndOfTest()).build()));
			 System.out.println("SignUp success");
			 Thread.sleep(3000);
			 
			 
			 //Login Native
			 
			 ExtentTest LoginNative = extent.createTest("LoginVative", "Failed");
			 
			 driver.findElementById("silktest.insurancemobile:id/email").click();  
			 driver.findElementById("silktest.insurancemobile:id/email").sendKeys("setiawan@gmail.com");
			 
			 LoginNative.log(Status.INFO, "Username Email 'setiawan@gmail.com'");
			 
			 System.out.println("Username Email");
			 
			 LoginNative.log(Status.PASS, "Username is Validation and proper");
			 
			 Thread.sleep(1000);
			 driver.findElementById("silktest.insurancemobile:id/password").click();  
			 driver.findElementById("silktest.insurancemobile:id/password").sendKeys("andre");
			 
			 LoginNative.log(Status.INFO, "Password added '*******'");
			 
			 System.out.println("Password entered");
			 
			 LoginNative.log(Status.PASS, "Password is validation and proper");
			 
			 driver.findElementById("silktest.insurancemobile:id/log_in_button").click();
			 
			 LoginNative.log(Status.INFO, "Login button clicked and user is redirwcting to home page");
			 
			 System.out.println("Login Button clicked");
			 
			 Thread.sleep(1000);
			 
			 LoginNative.log(Status.PASS, "Login button successfully clicked");
			 
			 LoginNative.log(Status.PASS, "Login Successful");
			 
			 Thread.sleep(2000);
			 
			 
			 mail.sendEmailatt(path);
			// return path;
		}
	}
	
	public static String takeScreenshotAtEndOfTest() throws IOException{
		String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	//	String destination = System.getProperty("${workspace}")+"\\target\\Result\\" +datename +".png";
		String destination = System.getProperty("user.dir")+"\\target\\Result\\" +datename +".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}



	
	

}
