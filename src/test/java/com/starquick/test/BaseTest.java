package com.starquick.test;

import com.starquick.manager.Driver;
import com.starquick.utils.PropertyUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {
	protected BaseTest() {
		
	}
	public String className;
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data){
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"));
		className = this.getClass().getSimpleName();
		PropertyUtils.setProperty(className);
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitdriver();
	}

}
