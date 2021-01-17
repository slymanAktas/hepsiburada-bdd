package bdd.pages;

import bdd.models.ui.Product;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends PageObject {

    private static final By proceedCheckOutBtn = By.xpath("//button[@name='processCarrier']/span | //span[text()='Proceed to checkout']");
    private static final By searchTextBox = By.id("search_query_top");


    public void isProductAddedToBasketSuccesfully(Product product) {
        Assert.assertTrue("Product couldn't be added to basket!", $(By.xpath("//a[text()='" + product.getDescription() + "']")).isPresent());

        List<String> allPricesForProduct = findAll(By.xpath("//a[text()='" + product.getDescription() + "']/../../../td[@class='cart_unit']/span/span"))
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
        Assert.assertTrue("Product price is different from orginal!", allPricesForProduct.contains(product.getPrice()));
    }

    public void clickProceedCheckOutBtn() {
        clickOn($(proceedCheckOutBtn));
    }

    public void searchByKeywordAs(String keyword) {
        $(searchTextBox).typeAndEnter(keyword);
    }
}
