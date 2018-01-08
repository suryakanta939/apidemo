package com.apidemo.screenshotlib;

import java.io.File;
import java.io.IOException;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
  
	public static String takeAScreenShot(WebDriver driver,String fileName) throws IOException{
		File f=new File("imageFolder");
		File fs=new File(f,"");
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
	    File dstFle=new File(fs.getAbsolutePath()+"//"+fileName+".png");
	    FileUtil.copyFile(srcFile, dstFle);
	    String filePath=fs.getAbsolutePath()+"//"+fileName+".png";
		return filePath;
		
	}
}
