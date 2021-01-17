package bdd.Steps.ui;

import bdd.models.ui.Product;
import bdd.pages.PaymentPage;
import net.thucydides.core.annotations.Step;

public class PaymentSteps {
    private PaymentPage paymentPage;

    @Step
    public PaymentSteps pay() {
        paymentPage.makePaymentRandomly();
        return this;
    }

    @Step
    public PaymentSteps epenOrderHistoryAndDetail() {
        paymentPage.openMyAccount().clickHistoryAndDetailBtn();
        return this;
    }

    public void checkOrder(Product product1, Product product2) {
        Double totalPrice = Double.parseDouble(product1.getPrice().substring(1)) + Double.parseDouble(product2.getPrice().substring(1));
        paymentPage.shouldTransactionSeeBetweenOrders();
    }
}
