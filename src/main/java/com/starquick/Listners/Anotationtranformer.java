package com.starquick.Listners;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.starquick.utils.DataProviderUtils;

/**
 * 
 * Create Anotation which help to Clear the test Case  to ADD MULTIPLE param in @test this would be Initialize here and @test Should be clear.
 * 
 * @author Faraz Dasurkar
 * @Version 1.0
 *@Since 2024
 */
@SuppressWarnings("rawtypes")
public class Anotationtranformer implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);




	}
}
