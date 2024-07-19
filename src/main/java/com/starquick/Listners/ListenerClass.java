package com.starquick.Listners;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.exceptions.FrameworkException;
import com.starquick.reports.ExtendLogger;
import com.starquick.reports.ExtendReport;
import com.starquick.utils.EmailSendUtils;
import org.testng.*;

import java.util.Arrays;

/**
 * Listerner Class which contains ItestListener and IsuiteListener which help to initialize Extend report.
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
public class ListenerClass implements ITestListener, ISuiteListener {

    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;
    static int count_totalTCs;

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
        count_totalTCs = count_totalTCs + 1;
        ExtendReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	try {
            count_passedTCs = count_passedTCs + 1;
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
            count_failedTCs = count_failedTCs + 1;
			ExtendLogger.fail(result.getMethod().getMethodName() +" is Failed",true);
			ExtendLogger.fail(result.getThrowable().toString());
			ExtendLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
          //  ZipUtils.zip();
          
        } catch (Exception e) {
			throw new FrameworkException("Some issue onTestFailure While Initalize");
		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        count_skippedTCs = count_skippedTCs + 1;
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
    	  EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
    }
}
