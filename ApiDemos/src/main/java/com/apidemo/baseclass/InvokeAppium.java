package com.apidemo.baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InvokeAppium {

	public static AndroidDriver<AndroidElement> runAppiumApkFile(String deviceName,String apkFileName) throws MalformedURLException{
		File f=new File("apkFolder");
		File fs=new File(f,apkFileName);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

	public static AndroidDriver<AndroidElement> runAppiumPreinstalled(String deviceName,String appPackage,String appActivity) throws MalformedURLException{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1.4723/wd/hub"),cap);
		return driver;
	}
	public static AndroidDriver<AndroidElement> runAppiumWithBrowser(String urDeviceName,String browseName) throws MalformedURLException{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, urDeviceName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,browseName);
		AndroidDriver<AndroidElement>	driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;

	}
	public static AndroidDriver<AndroidElement> runappiumBrowserStack(String userName,String accessKey) throws MalformedURLException{
		 DesiredCapabilities caps = new DesiredCapabilities();

		    caps.setCapability("device", "Google Pixel");
		    
		    caps.setCapability("app", "bs://91259592108e0c91bff672a189ec134cd6614be4");

		    AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
			return driver;

	}
}
