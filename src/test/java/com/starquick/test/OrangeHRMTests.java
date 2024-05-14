package com.starquick.test;


import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.starquick.Listners.RetryFailedTests;
import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.enums.CatogoryType;
import com.starquick.pages.OrangeHRMLoginPage;
import com.starquick.utils.DataProviderUtils;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests(){}
	
	@FrameworkAnotation(author = {"Faraz","Dasurkar"}, category = {CatogoryType.SANITY,CatogoryType.SMOKE })
	@Test(dataProvider ="getData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTests.class)
	protected void loginlogout(HashMap<String, String> data) {
		
		String pageTitle;
		try {
			pageTitle = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickonlogin()
			.clickWelcome().clickLogout().pageTitle();
			Assertions.assertThat(pageTitle).isEqualTo("OrangeHRM");
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	
}
