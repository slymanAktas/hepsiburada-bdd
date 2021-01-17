package bdd.pages;

import bdd.models.ui.Address;
import bdd.models.ui.Buyer;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DefaultUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account")
public class SignUpPage extends PageObject {

    private static final By emailTextBox = By.id("email_create");
    private static final By maleGenderRadio = By.id("id_gender1");
    private static final By feMaleGenderRadio = By.id("id_gender2");
    private static final By firstName1TextBox = By.id("customer_firstname");
    private static final By lastName1TextBox = By.id("customer_lastname");
    private static final By passwordTextBox = By.id("passwd");
    private static final By firstName2TextBox = By.id("firstname");
    private static final By lastName2TextBox = By.id("lastname");
    private static final By addressTextBox = By.id("address1");
    private static final By cityTextBox = By.id("city");
    private static final By stateSelectBox = By.id("id_state");
    private static final By postCodeTextBox = By.id("postcode");
    private static final By phoneTextBox = By.id("phone_mobile");
    private static final By registerButton = By.id("submitAccount");
    private static final By username = By.className("account");
    private static final By aliasTextBox = By.id("alias");

    private HomePage homePage;

    public HomePage signUpThenLogsIn(Buyer buyer, Address address) {
        homePage.clickSignInButton();
        $(emailTextBox).typeAndEnter(buyer.getEmail());

        if (buyer.getTitle().equalsIgnoreCase("Mr")) clickOn($(maleGenderRadio));
        else clickOn($(feMaleGenderRadio));
        typeInto($(firstName1TextBox), buyer.getFirstName());
        typeInto($(lastName1TextBox), buyer.getLastName());
        typeInto($(passwordTextBox), buyer.getPassword());

        typeInto($(firstName2TextBox), buyer.getFirstName());
        typeInto($(lastName2TextBox), buyer.getLastName());
        typeInto($(addressTextBox), address.getAddress());
        typeInto($(cityTextBox), address.getCity());
        selectFromDropdown($(stateSelectBox), address.getState());
        typeInto($(postCodeTextBox), address.getPostalCode());
        typeInto($(phoneTextBox), address.getPhone());
        typeInto($(aliasTextBox), "");
        typeInto($(aliasTextBox), address.getAlias());

        clickOn($(registerButton));

        return homePage;
    }

    public void checkBuyerCanLoggedIn() {
        assertThat("Buyer couln't be sign in!", $(username).getText(), is(equalTo("suleyman aktas")));
    }
}
