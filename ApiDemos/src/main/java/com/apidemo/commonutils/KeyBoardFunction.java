package com.apidemo.commonutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class KeyBoardFunction {

	public static void clickOnBack(AndroidDriver<AndroidElement> driver,int noOftime) throws InterruptedException
	{
		for(int i=0;i<noOftime;i++){
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(500);
		
		}
	}
}
