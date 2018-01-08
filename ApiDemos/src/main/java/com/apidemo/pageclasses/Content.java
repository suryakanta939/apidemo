package com.apidemo.pageclasses;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Content {

	static AndroidDriver<AndroidElement> driver;
	static AndroidElement element;
	static List<AndroidElement> elements;
	static ExtentTest test;
	
	public Content(AndroidDriver<AndroidElement> driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		
	}
	public static AndroidElement content(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Content']");
		return element;
	}
	
	public static AndroidElement assets(){
		element=driver.findElementByXPath("//android.widget.TextView[@content-desc='Assets']");
		return element;
	}
	
	public static AndroidElement readAssest(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Read Asset']");
		return element;
	}
	public static AndroidElement texts(){
		element=driver.findElementByXPath("//android.widget.TextView[contains(@text,' placed into the TextView here')]");
		return element;
	}
	public static AndroidElement Readingtexts(){
		element=driver.findElementById("io.appium.android.apis:id/clip_text");
		return element;
	}
	public static AndroidElement clipBoard(){
		element=driver.findElementByXPath("//android.widget.TextView[@text='Clipboard']");
		return element;
	}
	
	public static List<AndroidElement> dataTypes(){
		elements=driver.findElementsByXPath("//android.widget.TextView[@text='Data Types']");
		return elements;
	}
	
	public static List<AndroidElement> copyText(){
		elements=driver.findElementsByXPath("//android.widget.Button[@text='Copy Text']");
		return elements;
	}
	
	public static AndroidElement copyIntent(){
		element=driver.findElementByXPath("//android.widget.Button[@text='Copy Intent']");
		return element;
	}
	
	public static AndroidElement copyURI(){
		element=driver.findElementByXPath("//android.widget.Button[@text='Copy URI']");
		return element;
	}
	
	
	public static AndroidElement spinner(){
		element=driver.findElementByClassName("android.widget.Spinner");
		return element;
	}
	
	
	public static List<AndroidElement> CheckedTextView(){
		elements=driver.findElementsByClassName("android.widget.CheckedTextView");
		return elements;
	}
/*
 * below functions are for the content
 * 
 * */
	public void clcikOnContent(){
		content().click();
	}
	
	public  void clcikOnAssests(){
		assets().click();
	}
	
	public void clcikOnReadAssest(){
		readAssest().click();
	}
	
	public void readTextFromAssest(){
		System.out.println(texts().getText());
	}
	
	
	public void performContent() throws InterruptedException{
		clcikOnContent();
		Thread.sleep(500);
		clcikOnAssests();
		Thread.sleep(500);
		clcikOnReadAssest();
		Thread.sleep(500);
		readTextFromAssest();
	}
	/*
	 * Below functions are for the clipboard
	 * 
	 * */
	
	public void clickOnClipBoard(){
		clipBoard().click();
	}
	
	public void clickOnDataType(){
		System.out.println(dataTypes().size());
		if(dataTypes().size()==1){
			
			dataTypes().get(0).click();
		}
		
	}
	
	public void performcopyText(){
		for(int i=0;i<copyText().size();i++){
			copyText().get(i).click();
			String msg=Readingtexts().getAttribute("text");
			System.out.println(msg);
		}
	}
	
	public void readTextFromClipBoard(){
		clickOnClipBoard();
		clickOnDataType();	
		performcopyText();
	}
	/*
	 * this function is to perform the function in spinners
	 * */
//	public void SelectingallTextsFromSpinner(){
//		int i=0;
//		spinner().click();
//		int totalNo=CheckedTextView().size();
//		System.out.println("Total elements present in spinner "+totalNo);
//		
//		while(i<=totalNo){
//			try{
//				
//			}
//		}
//	}
	
	public void spinnerFunction() throws InterruptedException{
		spinner().click();
		System.out.println(CheckedTextView().size());
		for(int i=0;i<CheckedTextView().size();i++){
			
			CheckedTextView().get(i).click();
			
			try{
				spinner().click();
				System.out.println(CheckedTextView().get(i).getAttribute("text"));
			}catch(Throwable t){
				if(dataTypes().size()==1){
					dataTypes().get(0).click();
					spinner().click();
				}
				continue;
			}
			
		}
	}
	
	public void scrollInspinner(){
		spinner().click();
		TouchAction act=new TouchAction(driver);
		AndroidElement listCheck=driver.findElementByClassName("android.widget.ListView");
		Point center=listCheck.getCenter();
		int xPoint=center.getX();
		int yPoint=center.getY();
		
		System.out.println("x "+xPoint);
		System.out.println("y "+yPoint);
		System.out.println();
		while(driver.findElementsByXPath("//android.widget.CheckedTextView[@text='No data in clipboard']").size()==0)
	//	act.press(xPoint, yPoint *2/3).waitAction().moveTo(xPoint,yPoint/3 ).release().perform();
			act.press(listCheck, xPoint, yPoint).waitAction().moveTo(xPoint,849 ).release().perform();
		//act.press(xPoint, (int) (yPoint* 0.80)).waitAction().moveTo(5, (int) (yPoint * 0.20)).release().perform();
		
	}
}
