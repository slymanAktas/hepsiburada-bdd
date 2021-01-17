package bdd.Steps.ui;

import bdd.models.ui.Address;
import bdd.models.ui.Buyer;
import bdd.pages.SignUpPage;
import net.thucydides.core.annotations.Step;


public class SignUpSteps {

    private SignUpPage signUpPage;

    @Step
    public void signUpThenLogsIn(Buyer buyer, Address address) {
        signUpPage.signUpThenLogsIn(buyer, address);
    }

    @Step
    public void checkBuyerCanLoggedIn() {
        signUpPage.checkBuyerCanLoggedIn();
    }

}
