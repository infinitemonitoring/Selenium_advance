package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;
import com.starquick.utils.DecodeUtils;

public final class OrangeHRMLoginPage  extends BasePage  {

	
	private final By Username = By.xpath("//input[@placeholder='Username']");
	private final By Password = By.xpath("//input[@placeholder='Password']");
	private final By loginbutton = By.xpath("//button[normalize-space()='Login']");
	
	
	
	public OrangeHRMLoginPage enterUsername(String username) throws Exception {
		
		sendkeys(waitStatergy.PRESENCE, Username, username,"Username Field");
		//DriverManager.getDriver().findElement(Username).sendKeys(username);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		
		sendkeys(waitStatergy.PRESENCE, Password, DecodeUtils.getDecodedString(password),"Password Field");
	//	DriverManager.getDriver().findElement(Password).sendKeys(password);
		return this;
	}
	public OrangeHRMHomepage clickonlogin() {
		
		click(waitStatergy.CLICKABLE, loginbutton, "Login Button");
		//DriverManager.getDriver().findElement(loginbutton).click();
		return new OrangeHRMHomepage();	
	}
	
}
