package com.starquick.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.starquick.manager.DriverManager;
import com.starquick.utils.DataProviderUtils;

import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	
	@Test()
	public void test1() {
		
		
		DriverManager.getDriver().findElement(By.xpath("//input[@id='search-input-top-nav-modal']")).sendKeys("Automation ", Keys.ENTER);
		
		
	}
	

}
