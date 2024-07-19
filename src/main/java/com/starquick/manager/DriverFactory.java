package com.starquick.manager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.starquick.enums.ConfigProperties;
import com.starquick.exceptions.FrameworkException;
import com.starquick.utils.PropertyUtils;

public final class DriverFactory {

	private DriverFactory() {}
	public static WebDriver getDriver(String browserName) throws MalformedURLException {
		WebDriver driver=null;
		String Runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browserName.equalsIgnoreCase("chrome")) {
				if(Runmode.equalsIgnoreCase("remote")) {
					ChromeOptions cap = new ChromeOptions();
					driver=  new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
				}else if(Runmode.equalsIgnoreCase("Selenoidremote")) {
					ChromeOptions options = new ChromeOptions();
					options.setCapability("selenoid:options", new HashMap<String, Object>() {{
					    put("name", "Selenoid Chrome");
					    put("sessionTimeout", "15m");
					    put("env", new ArrayList<String>() {{
					        add("TZ=UTC");
					    }});
					    put("labels", new HashMap<String, Object>() {{
					        put("manual", "false");
					    }});
					    put("enableVideo", true);
					    put("enableVNC",true);
					}});
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
				}
				else {
					driver= new ChromeDriver();
					
				}
			}else  if(browserName.equalsIgnoreCase("edge")){
				if(Runmode.equalsIgnoreCase("remote")) {
					EdgeOptions cap = new EdgeOptions();
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
				}else if(Runmode.equalsIgnoreCase("Selenoidremote")) {
					throw new FrameworkException("error on Selenoid Edge Run");
				}
				else {
					driver= new EdgeDriver();	
				}
			}else  if(browserName.equalsIgnoreCase("firefox")){
				if(Runmode.equalsIgnoreCase("remote")) {
					FirefoxOptions cap = new FirefoxOptions();
					driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)),cap);
				}else if(Runmode.equalsIgnoreCase("Selenoidremote")) {
					FirefoxOptions options = new FirefoxOptions();
					options.setCapability("selenoid:options", new HashMap<String, Object>() {{
					    put("name", "Selenoid FireFox");
					    put("sessionTimeout", "15m");
					    put("env", new ArrayList<String>() {{
					        add("TZ=UTC");
					    }});
					    put("labels", new HashMap<String, Object>() {{
					        put("manual", "false");
					    }});
					    put("enableVideo", true);
					    put("enableVNC",true);
					}});
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
				}
				else {
					driver = new FirefoxDriver();	
				}
			}
		}
		return driver;
	}
}