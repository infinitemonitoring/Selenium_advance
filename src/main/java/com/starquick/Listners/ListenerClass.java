package com.starquick.Listners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.reports.ExtendLogger;
import com.starquick.reports.ExtendReport;
import com.starquick.reports.ExtendReportManager;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
    	try {
			ExtendReport.initreport();
		} catch (Exception e) {
			
		}
    }

    @Override
    public void onFinish(ISuite suite) {
    
			try {
				ExtendReport.flushreport();
			} catch (Exception e) {
			
			}
    }

    @Override
    public void onTestStart(ITestResult result) {
    	ExtendReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	try {
			ExtendLogger.pass(result.getMethod().getMethodName() +" is Pass",true);
			ExtendReport.addauthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnotation.class).author());
			ExtendReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnotation.class).category());
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	//ExtendLogger.fail(result.getMethod().getMethodName() +" is Failed");
    	try {
			ExtendLogger.fail(result.getMethod().getMethodName() +" is Failed",true);
			ExtendLogger.fail(result.getThrowable().toString());
			ExtendLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	ExtendLogger.skip(result.getMethod().getMethodName() +" is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //didn't use this thing
    }


    @Override
    public void onStart(ITestContext context) {
// we have only one test for now.
    }

    @Override
    public void onFinish(ITestContext context) {
// we have only one test from now.
    }
}
