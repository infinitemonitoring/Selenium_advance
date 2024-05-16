package com.starquick.reports;

import com.aventstack.extentreports.ExtentTest;
/**
 * 
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
public final class ExtendReportManager {
	
	
	private ExtendReportManager(){
		
	}
private static ThreadLocal<ExtentTest> tr =  new ThreadLocal<>();
	
	 static ExtentTest getExtendTest() {
		return tr.get();
	}
	
	 static void setExtendTest(ExtentTest test) {
		tr.set(test);
	}
	 static void unload() {
	tr.remove();
	}

}
