package com.starquick.reports;

import com.starquick.utils.screenShotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

public class ExtendLogger {
	
	private ExtendLogger() {}
	
	public static void  pass(String message) {
		ExtendReportManager.getExtendTest().pass(message);
	}

	public static void fail(String message) {
		ExtendReportManager.getExtendTest().fail(message);
		
	}

	public static void skip(String message) {
		ExtendReportManager.getExtendTest().skip(message);
		
	}

	public static void info(String message) {
		ExtendReportManager.getExtendTest().info(message);	
	}
	
	public static void pass(String message, Boolean isScreenshotNeeded) throws Exception {
		
//		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotUtils.getBase64Image()).build());
			
//		}else {
//			pass(message);
//		}
	}
	public static void fail(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotUtils.getBase64Image()).build());
			System.out.println("Inside Screenshot File ");
		}
		else {
			fail(message);
		}
	}
	public static void skip(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotUtils.getBase64Image()).build());
			
		}else {
			skip(message);
		}
	}
	public static void info(String message, Boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.INFOSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded){
			ExtendReportManager.getExtendTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShotUtils.getBase64Image()).build());
			
		}else {
			info(message);
		}
	}
	

}