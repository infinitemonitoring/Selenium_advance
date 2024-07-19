package com.starquick.pages;

import org.openqa.selenium.By;

import com.starquick.enums.waitStatergy;

public final class CartLandingPage3 extends BasePage {

	private final By Cart = By.xpath("//span[@class='cart-text']");
	private final By clicksearech = By.xpath("//*[@id='search-input-top-nav-modal']");
	public CartLandingPage3 clicksearch() {
		click(waitStatergy.CLICKABLE, Cart, "Cart");
		return this;
	}

	public CartLandingPage3 Milksearchproduct() {
		click(waitStatergy.CLICKABLE, Cart, "Cart");
		return this;
	
	
}
}

