package bdd.Steps.ui;

import bdd.models.ui.Product;
import bdd.pages.SearchPage;
import net.thucydides.core.annotations.Step;

public class SearchSteps {
    private SearchPage searchPage;

    @Step
    public Product addRandomProductToBasket() {
        return searchPage.addRandomProductToBasket();
    }
}
