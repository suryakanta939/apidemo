package com.apidemo.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.apidemo.baseclass.AppiumServer;
import com.apidemo.baseclass.InvokeAppium;
import com.apidemo.commonutils.KeyBoardFunction;
import com.apidemo.pageclasses.Content;
import com.apidemo.pageclasses.Preference;
import com.apidemo.pageclasses.Text;
import com.apidemo.screenshotlib.ScreenShot;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Check  {
	AndroidDriver<AndroidElement> driver;
	ExtentTest test;
//	@Parameters({"browser","URL"})
//	@BeforeTest
//	public void setUp(String browser,String url){
//		
//	}
  @Test
  public void f() throws IOException, InterruptedException {
	 driver=InvokeAppium.runAppiumApkFile("android device", "ApiDemos-debug.apk");
	 // driver=InvokeAppium.runappiumBrowserStack("ashwini107", "RAXXVyic3YSEmYQHWvz1");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Preference pr=new Preference(driver, test);
	Content con=new Content(driver, test);
	Text txt=new Text(driver, test);
//	pr.checkPreference();
//	KeyBoardFunction.clickOnBack(driver, 2);
//	Thread.sleep(1000);
	con.performContent();
	KeyBoardFunction.clickOnBack(driver, 2);
	Thread.sleep(500);
	con.readTextFromClipBoard();
	//con.spinnerFunction();
	con.scrollInspinner();
  }
}
