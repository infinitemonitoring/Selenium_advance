package com.starquick.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;
import com.starquick.enums.waitStatergy;
import com.starquick.manager.Driver;
import com.starquick.manager.DriverManager;
import com.starquick.pages.TataMilkSearchpage;

public final class TATAOpenLandingPage extends BasePage {

	private final static By AllCategories = By.xpath("//span[@class='all-cat']");
	private final By logoimageassert = By.xpath("//*[@class='starlogo mobile-starlogo']");
	private final By clicksearech = By.xpath("//*[@id='search-input-top-nav-modal']");
	

	public TATAOpenLandingPage clicksearch()  {
		Uninterruptibles.sleepUninterruptibly(30, TimeUnit.SECONDS);
		click(waitStatergy.CLICKABLE,clicksearech,"clicksearech");
		return this;
	}
	public TataMilkSearchpage searchproduct(String searchfieldtext)  {
		sendkeys(waitStatergy.CLICKABLE, clicksearech, searchfieldtext, "Search Field");
		//DriverManager.getDriver().findElement(Username).sendKeys(username);
		return  new TataMilkSearchpage();
	}
public static  String allcat() {
	return DriverManager.getDriver().findElement(AllCategories).getText();
}
	
}

//*[@id='search-input-top-nav-modal']