package bdd.pages;

import bdd.models.ui.Product;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class ProductsPage extends PageObject {
    private static final By productList = By.cssSelector(".product_list li[class*='product']");
    private static final By proceedToCheckOut = By.cssSelector("a[title='Proceed to checkout']");

    public Product addRandomProductToBasket() {
        List<WebElementFacade> producs = findAll(productList);
        WebElementFacade randomProduct = producs.get(new Random().nextInt(producs.size()));
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView(true);", randomProduct);
        withAction().moveToElement(randomProduct).perform();
        waitABit(500);

        Product product = initProduct(randomProduct);

        clickOn(randomProduct.find(By.xpath(".//span[text()='Add to cart']")));
        waitABit(500);
        clickOn($(proceedToCheckOut));

        return product;
    }

    private Product initProduct(WebElementFacade elementFacade) {
        return new Product(
                elementFacade.find(By.xpath(".//a[@class='product-name']")).getText().trim(),
                elementFacade.find(By.xpath(".//span[contains(@class, 'product-price')]")).getText().trim(),
                elementFacade.find(By.xpath(".//span[@class='available-now']")).getText().equalsIgnoreCase("available-now")
        );
    }
}
