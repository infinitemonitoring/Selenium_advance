package com.starquick.test;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.enums.CatogoryType;
import com.starquick.pages.TATAOpenLandingPage;

public final class starquickAddproduct extends BaseTest {

	
	@FrameworkAnotation(author = {"Faraz","Yogesh"}, category = {CatogoryType.SANITY,CatogoryType.SMOKE })
	@Test
	protected void Searchproduct()  {
	
		String allct = 	new TATAOpenLandingPage().clicksearch().allcat();
		
		
		
	}

}
