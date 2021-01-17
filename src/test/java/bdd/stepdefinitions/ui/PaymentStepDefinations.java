package bdd.stepdefinitions.ui;
import bdd.Steps.ui.*;
import bdd.models.ui.Address;
import bdd.models.ui.Buyer;
import bdd.models.ui.Product;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class PaymentStepDefinations {

    @Steps
    private SignUpSteps signUpSteps;

    @Steps
    private HomePageSteps homePageSteps;

    @Steps
    private BasketSteps basketSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private AddressSteps addressSteps;

    @Steps
    private ShippingSteps shippingSteps;

    @Steps
    private PaymentSteps paymentSteps;

    private Address address = Address.initAddress();

    private Buyer buyer = Buyer.initBuyer();

    private Product product1, product2;

    @Given("Buyer sign up to site then logs in")
    public void buyer_sign_up_to_site_then_logs_in() {
        signUpSteps.signUpThenLogsIn(buyer, address);
    }

    @Then("Buyer should been registered successfully")
    public void buyer_should_been_registered_successfully() {
        signUpSteps.checkBuyerCanLoggedIn();
    }

    @When("Buyer goes category page which defined below")
    public void buyer_goes_category_page_which_defined_below(List<Map<String, String>> categories) {
        for (Map.Entry<String, String> entry : categories.get(0).entrySet()) {
            homePageSteps.goCategories(entry.getKey(), entry.getValue()).run();
        }
    }

    @And("^Buyer adds random product to basket from categories$")
    public void buyerAddsRandomProductToBasketFromCategories() {
        product1 = homePageSteps.addRandomProductToBasket();
    }

    @And("^First product should been added to basket successfully$")
    public void firstProductShouldBeenAddedToBasketSuccessfully() {
        basketSteps.checkProductWhichAddedToBasket(product1);
    }

    @And("^Buyer has searched for \"([^\"]*)\"$")
    public void buyerHasSearchedFor(String keyword) throws Throwable {
        basketSteps.search(keyword);
    }

    @And("^Buyer adds random product to basket from search results$")
    public void buyerAddsRandomProductToBasketFromSearchResults() {
        product2 = searchSteps.addRandomProductToBasket();
    }

    @And("^Second product should been added to basket successfully$")
    public void secondProductShouldBeenAddedToBasketSuccessfully() {
        basketSteps.checkProductWhichAddedToBasket(product2);
        basketSteps.goToNextTab();
    }

    @When("Buyer chooses an address")
    public void buyer_chooses_an_address() {
        addressSteps.checkAddressInfoOfBasket(address);
        basketSteps.goToNextTab();
    }


    @When("Buyer accepts cargo option and terms of service")
    public void buyer_accepts_cargo_option_and_terms_of_service() {
        shippingSteps.agreeTermOfServie();
        basketSteps.goToNextTab();
    }


    @When("Buyer chooses payment type then complates payment")
    public void buyer_chooses_payment_type_then_complates_payment() {
        paymentSteps.pay();
    }

    @Then("Buyer should see the transaction on Order History And Details page successfully")
    public void buyer_should_see_the_transaction_on_Order_History_And_Details_page_successfully() {
        paymentSteps.epenOrderHistoryAndDetail().checkOrder(product1, product2);

    }
}
