package bdd.Steps.ui;

import bdd.models.ui.Product;
import bdd.pages.BasketPage;
import net.thucydides.core.annotations.Step;


public class BasketSteps {

    private BasketPage basketPage;

    @Step
    public BasketSteps checkProductWhichAddedToBasket(Product product) {
        basketPage.isProductAddedToBasketSuccesfully(product);
        return this;
    }

    @Step
    public BasketSteps goToNextTab() {
        basketPage.clickProceedCheckOutBtn();
        return this;
    }

    @Step
    public SearchSteps search(String keyword) {
        basketPage.searchByKeywordAs(keyword);
        return new SearchSteps();
    }
}
