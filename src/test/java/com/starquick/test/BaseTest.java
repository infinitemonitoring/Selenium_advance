package com.starquick.test;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.starquick.manager.Driver;
import com.starquick.utils.PropertyUtils;

public class BaseTest {
	protected BaseTest() {
		
	}
	public String className;
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data){
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"));
		LogManager.getLogger().info("Driver Initialize successfully");
		className = this.getClass().getSimpleName();
		PropertyUtils.setProperty(className);
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitdriver();
		LogManager.getLogger().info("Driver Quit successfully");
	}

}
