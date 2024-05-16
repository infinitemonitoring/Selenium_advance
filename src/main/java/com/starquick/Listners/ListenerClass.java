package com.starquick.Listners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.exceptions.FrameworkException;
import com.starquick.reports.ExtendLogger;
import com.starquick.reports.ExtendReport;

/**
 * Listerner Class which contains ItestListener and IsuiteListener which help to initialize Extend report.
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
public class ListenerClass implements ITestListener, ISuiteListener {

	
    @Override
    public void onStart(ISuite suite) {
    	try {
			ExtendReport.initreport();
		} catch (Exception e) {
			throw new FrameworkException("Some issue onStart while Initalize Report");
		}
    }

    @Override
    public void onFinish(ISuite suite) {
    
			try {
				ExtendReport.flushreport();
			} catch (Exception e) {
				throw new FrameworkException("Some issue onFinish while Flashing Report");
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
			throw new FrameworkException("Some issue onTestSuccess While Initalize");
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
			throw new FrameworkException("Some issue onTestFailure While Initalize");
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
