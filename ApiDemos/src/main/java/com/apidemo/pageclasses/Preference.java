package com.apidemo.pageclasses;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Preference {
 static AndroidDriver<AndroidElement> driver;
 static AndroidElement element;
 static ExtentTest test;
 
	public Preference(AndroidDriver<AndroidElement> driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	//
	public static AndroidElement preference(){
		element=driver.findElementByXPath("//android.widget.TextView[@index='8']");
		return element;
	}
   public static AndroidElement preferenceFromCode(){
	   element=driver.findElementByXPath("//android.widget.TextView[contains(@text,'from code')]");
	   return element;
   }
   
   public static AndroidElement switchPreference(){
	   element=driver.findElementByXPath("//android.widget.Switch[@text='OFF']");
	   return element;
   }
   
  public static void checkPreference() throws InterruptedException{
	  preference().click();
	  Thread.sleep(500);
	  preferenceFromCode().click();
	  Thread.sleep(500);
	  switchPreference().click();
  }
}
