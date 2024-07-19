package com.starquick.pages;

import org.openqa.selenium.By;
import com.starquick.enums.waitStatergy;

/**
 * Represents the final page in the checkout process of the application.
 * This page contains methods to interact with elements on the final checkout page.
 */
public final class FinalPage5 extends BasePage {

    // Locator for the "Proceed to Checkout" button
    private final By proceedtocheckout = By.xpath("//div[@class='checkout-page-checkout-button-container checkout-trigger']");

    /**
     * Clicks on the "Proceed to Checkout" button.
     *
     * @return a new instance of FinalPage5
     */
    public FinalPage5 proceedtocheckout() {
        click(waitStatergy.CLICKABLE, proceedtocheckout, "proceedtocheckout");
        return new FinalPage5();
    }
}
