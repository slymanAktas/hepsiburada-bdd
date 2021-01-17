package bdd.Steps.ui;

import bdd.models.ui.Address;
import bdd.pages.AddressPage;
import net.thucydides.core.annotations.Step;

public class AddressSteps {
    AddressPage addressPage;

    @Step
    public AddressSteps checkAddressInfoOfBasket(Address address) {
        addressPage.shouldAddressDisplayedAsSuccessfuly(address);
        return this;
    }

}
