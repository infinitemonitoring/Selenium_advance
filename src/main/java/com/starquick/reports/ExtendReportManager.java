package com.starquick.reports;

import com.aventstack.extentreports.ExtentTest;

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
