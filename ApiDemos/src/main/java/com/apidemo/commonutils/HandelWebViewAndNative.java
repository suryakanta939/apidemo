package com.apidemo.commonutils;

import java.util.Set;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HandelWebViewAndNative {
  
	public static void switchToWebView(AndroidDriver<AndroidElement> driver){
		Set<String> contexts=driver.getContextHandles();
		for(String context:contexts){
			if(context.equals("WEBVIEW")){
				driver.context(context);
			}
		}
	}
	
	public static void switchToNativeView(AndroidDriver<AndroidElement> driver){
		Set<String> contexts=driver.getContextHandles();
		for(String context:contexts){
			if(context.equals("NATIVE")){
				driver.context(context);
			}
		}
	}
}
