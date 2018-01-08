package com.apidemo.reportlib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentFactory {
   static ExtentReports report;
   ExtentTest test;
	public static ExtentReports getInstace(){
		File f=new File("reportFolder");
		File fs=new File(f,"");
		report=new ExtentReports(fs.getAbsolutePath()+"//demo.html", false);
		return report;
	}
}
