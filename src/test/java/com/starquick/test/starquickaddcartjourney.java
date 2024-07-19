package com.starquick.test;

import com.starquick.customAnotation.FrameworkAnotation;
import com.starquick.enums.CatogoryType;
import com.starquick.pages.TATAOpenLandingPage1;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.HashMap;

public final class starquickaddcartjourney extends BaseTest {

	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void Milksearchproduct(HashMap<String, String> data) {

			String product_search_Amul_Masti_Dahi_Pouch = new TATAOpenLandingPage1().clicksearch()
					.searchproduct(data.get("product") + Keys.ENTER).Amulmilk().clicksearch()
					.searchproduct(data.get("SecondProduct") + Keys.ENTER).product_search_Amul_Masti_Dahi_Pouch();
			Assertions.assertThat(product_search_Amul_Masti_Dahi_Pouch).containsIgnoringCase("Continue").isNotNull();
		
				
	}

	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void Rusksearchproduct(HashMap<String, String> data) throws InterruptedException {

		String product_search_rusk = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).Rusk().after_Add_to_Cart_closebutton().clicksearch()
				.searchproduct(data.get("SecondProduct") + Keys.ENTER).BritaniaRusk();

	}
	
	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void Onionsearchproduct(HashMap<String, String> data) {

		String onion = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).onion();

	}
	
	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void detergentsearchproduct(HashMap<String, String> data) {

		String searchdetergent = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).searchdetergent();

	}
	
	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void searchcookoil(HashMap<String, String> data) {

		String searchcookoil = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).searchcookoil();

	}
	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void sprite(HashMap<String, String> data) {

		String softdrink = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).sprite();

	}
	
	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void atta(HashMap<String, String> data) {

		String atta = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).atta();
	}
	
	@FrameworkAnotation(author = { "Faraz", "Yogesh" }, category = { CatogoryType.SANITY })
	@Test
	protected void Tata_Agni_Leaf_Tea_Pouch(HashMap<String, String> data) {

		String tatatea = new TATAOpenLandingPage1().clicksearch()
				.searchproduct(data.get("product") + Keys.ENTER).Tata_Agni_Leaf_Tea_Pouch();
	

	}
	
}
