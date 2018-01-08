package com.apidemo.testcase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.apidemo.baseclass.InvokeAppium;
import com.apidemo.commonutils.KeyBoardFunction;
import com.apidemo.pageclasses.Preference;
import com.apidemo.pageclasses.Text;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckIng {
	static AndroidDriver<AndroidElement> driver;
	static ExtentTest test;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		try{
			 driver=InvokeAppium.runappiumBrowserStack("ashwini107", "RAXXVyic3YSEmYQHWvz1");
		}catch(Throwable t){
		System.out.println(t.getMessage());
		}
		 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Preference pr=new Preference(driver, test);
			Text txt=new Text(driver, test);
			pr.checkPreference();
			KeyBoardFunction.clickOnBack(driver, 2);
			txt.checkAllLink();

	}

}
