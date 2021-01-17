package bdd.pages;

import bdd.models.ui.Address;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class AddressPage extends PageObject {

    private static final By chooseDeliveryAddressSelectBox = By.id("id_address_delivery");
    private static final By addressText = By.cssSelector("#address_delivery .address_address1.address_address2");
    private static final By addressName = By.cssSelector("#address_delivery .address_firstname.address_lastname");
    private static final By addressCountryName = By.cssSelector("#address_delivery .address_country_name");
    private static final By addressPhoneNumber = By.cssSelector("#address_delivery .address_phone_mobile");
    private static final By addressInfo = By.cssSelector("#address_delivery .address_city.address_state_name.address_postcode");

    public void shouldAddressDisplayedAsSuccessfuly(Address address) {
        selectFromDropdown($(chooseDeliveryAddressSelectBox), address.getAlias());

        Assert.assertThat("Address name was wrong!", $(addressName).getText(), is(equalTo("suleyman aktas")));
        Assert.assertThat("City was wrong!", $(addressText).getText(), is(equalTo(address.getAddress())));
        Assert.assertTrue("Postal Code was wrong!", $(addressInfo).getText().contains(address.getPostalCode()));
        Assert.assertTrue("State was wrong!", $(addressInfo).getText().contains(address.getState()));
        Assert.assertThat("Country was wrong!", $(addressCountryName).getText(), is(equalTo(address.getCountry())));
        Assert.assertThat("Phone Numbber was wrong!", $(addressPhoneNumber).getText(), is(equalTo(address.getPhone())));
    }
}
