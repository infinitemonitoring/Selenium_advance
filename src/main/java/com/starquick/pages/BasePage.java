package com.starquick.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.starquick.enums.waitStatergy;
import com.starquick.factories.ExplicitWaitFactory;
import com.starquick.manager.DriverManager;
import com.starquick.reports.ConsoleLoggerImpl;
import com.starquick.reports.ExtendLogger;
import com.starquick.reports.ExtendloggerImpl;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;


public class BasePage {
	
	protected void click(waitStatergy wait,By by, String elementName)   {
		for(int i =0; i<=5;i++)
		{
			try {
			ExplicitWaitFactory.performexplicitwait(wait,by).click();
			ExtendLogger.pass(elementName +" is clicked");
			LogManager.getLogger().info(elementName +" is clicked");
			break;
			}
			catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				LogManager.getLogger().info(elementName +" is not able clicked");
				ExtendLogger.fail(elementName +" is not able clicked");
			}
		}
		
	}
	protected void sendkeys(waitStatergy wait, By by, String value, String elementName) {
		for(int i =0; i<=5;i++)
		{
			try {
		ExplicitWaitFactory.performexplicitwait(wait,by).sendKeys(value);
		ExtendLogger.pass(value + " is Successfully enter in " + elementName);
		LogManager.getLogger().info(value + " is Successfully enter in " + elementName);
		break;
		}catch (StaleElementReferenceException | ElementClickInterceptedException e) {
			LogManager.getLogger().info(elementName +" is not able Send keys");
			ExtendLogger.fail(elementName +" is not able send keys");
		}
		}
	}
	
	protected String getPageTitle() {
		ExtendLogger.info("Page Title is Successfully fetch");
		return DriverManager.getDriver().getTitle();
	}
	
	protected String getText(By by) {
		return ExplicitWaitFactory.performexplicitwait(waitStatergy.VISIBLE,by).getText();
		
	}
	protected void clickjs(waitStatergy wait,By by, String elementName)   {
		for(int i =0; i<=5;i++)
		{
			try {
				ExplicitWaitFactory.performexplicitwait(wait,by);
				JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
				WebElement element = DriverManager.getDriver().findElement(by);
				js.executeScript("arguments[0].click();",element);
				ExtendLogger.pass(elementName +" is clicked");
				LogManager.getLogger().info(elementName +" is clicked");
				break;
			}
			catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				LogManager.getLogger().info(elementName +" is not able clicked");
				ExtendLogger.fail(elementName +" is not able clicked");
				
			}
		}

	}
	protected void waiter(){
		Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);
	}


}
