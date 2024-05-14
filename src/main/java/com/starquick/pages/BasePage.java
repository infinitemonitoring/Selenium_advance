package com.starquick.pages;

import org.openqa.selenium.By;
import com.starquick.manager.DriverManager;

import com.starquick.enums.waitStatergy;
import com.starquick.factories.ExplicitWaitFactory;
import com.starquick.reports.ExtendLogger;



public class BasePage {
	
	protected void click(waitStatergy wait,By by, String elementName)   {
		ExplicitWaitFactory.performexplicitwait(wait,by).click();
		
			ExtendLogger.pass(elementName +" is clicked");
		
	}
	protected void sendkeys(waitStatergy wait, By by, String value, String elementName) {
		ExplicitWaitFactory.performexplicitwait(wait,by).sendKeys(value);
		ExtendLogger.pass(value + " is Successfully enter in " + elementName);
	}
	
	protected String getPageTitle() {
		ExtendLogger.info("Page Title is Successfully fetch");
		return DriverManager.getDriver().getTitle();
	}


}
