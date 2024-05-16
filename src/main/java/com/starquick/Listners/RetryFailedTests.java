package com.starquick.Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;
/**
 * Retry test cases
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
public class RetryFailedTests implements IRetryAnalyzer {

	private int count =0;
	private int retries =1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			{
				value = count<retries;
				count++;
			}
	
		return value;
	}

}
