package bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class PaymentPage extends PageObject {
    private static final By paymentModules = By.cssSelector("p.payment_module a");
    private static final By confirmOrederBtn = By.cssSelector("p#cart_navigation button[type='submit']");
    private static final By myAccountLink = By.className("account");
    private static final By orderHistoryAndDetailBtn = By.xpath("//span[text()='Order history and details']");
    private static final By priceTextBox  =By.cssSelector("table#order-list tbody tr td.history_price");

    public void makePaymentRandomly() {
        List<WebElementFacade> paymentMethods = findAll(paymentModules);
        clickOn(paymentMethods.get(new Random().nextInt(paymentMethods.size())));

        clickOn($(confirmOrederBtn));
    }

    public PaymentPage openMyAccount() {
        clickOn($(myAccountLink));
        return this;
    }

    public void clickHistoryAndDetailBtn(){
        clickOn($(orderHistoryAndDetailBtn));
    }

    public void shouldTransactionSeeBetweenOrders() {
        Assert.assertTrue("Transaction displayed by mistale", $(priceTextBox).isPresent());
    }
}
