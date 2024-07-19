package com.starquick.factories;

import java.time.Duration;

import com.starquick.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.starquick.manager.DriverManager;

import com.starquick.enums.waitStatergy;

public class ExplicitWaitFactory {

	public static WebElement performexplicitwait(waitStatergy waitStrategy, By by) {
		WebElement element=null;
		if (waitStrategy == waitStatergy.CLICKABLE) {
			  element=  new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == waitStatergy.PRESENCE) {
			element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == waitStatergy.VISIBLE) {
			element=  new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == waitStatergy.NONE) {
			element=DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
