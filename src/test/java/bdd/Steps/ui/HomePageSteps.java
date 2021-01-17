package bdd.Steps.ui;

import bdd.models.ui.Product;
import bdd.pages.CategoryPage;
import bdd.pages.HomePage;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class HomePageSteps {
    private HomePage homePage;
    private CategoryPage categoryPage;

    @Step
    public Runnable goCategories(String key, String value) {
        Map<String, Runnable> hashMap = new HashMap<>();

        hashMap.put("rootCategory", () -> homePage.selectRootCategory(value));
        hashMap.put("subCategory", () -> homePage.selectSubCategory(value));

        return hashMap.get(key);
    }

    @Step
    public Product addRandomProductToBasket() {
        return categoryPage.addRandomProductToBasket();
    }
}
