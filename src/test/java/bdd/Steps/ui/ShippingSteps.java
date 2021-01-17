package bdd.Steps.ui;

import bdd.pages.ShippingPage;
import net.thucydides.core.annotations.Step;

public class ShippingSteps {
    private ShippingPage shippingPage;

    @Step
    public ShippingSteps agreeTermOfServie() {
        shippingPage.clickTermOfServiceBox();
        return this;
    }
}
