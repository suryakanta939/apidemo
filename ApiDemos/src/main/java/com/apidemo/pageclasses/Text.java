package com.apidemo.pageclasses;

import org.apache.tools.ant.filters.LineContains.Contains;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Text {
 static AndroidDriver<AndroidElement> driver;
 static AndroidElement element;
 static ExtentTest test;
	public Text(AndroidDriver<AndroidElement> driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public static AndroidElement text(){
    element=driver.findElement(By.xpath("//android.widget.TextView[@text='Text']"));
    return element;
	}
	
	public static AndroidElement linkyfy(){
		 element=driver.findElement(By.xpath("//android.widget.TextView[@text='Linkify']"));
		    return element;
	}
	
	public static void checkAllLink(){
		text().click();
		linkyfy().click();
	}
	
}
