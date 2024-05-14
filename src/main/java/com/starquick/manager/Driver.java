package com.starquick.manager;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.starquick.enums.ConfigProperties;
import com.starquick.utils.PropertyUtils;

public final class Driver {
	private Driver() {
		
	}
	
	
	

	

	public static void initDriver(String browserName) throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browserName.equalsIgnoreCase("chrome")) {
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			}else  if(browserName.equalsIgnoreCase("edge")){
				DriverManager.setDriver(new EdgeDriver());
				DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
				
			}
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			DriverManager.getDriver().manage().window().maximize();
		}
		
	}
	
	
	public static void quitdriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

	
	
	
}
