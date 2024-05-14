package com.starquick.Listners;

import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count =0;
	private int retries =2;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			{
				value = count<retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
