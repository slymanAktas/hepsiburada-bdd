package bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import static bdd.utils.StringUtils.capitelizeOnlyFirstLetter;

@DefaultUrl("http://automationpractice.com/index.php")
public class HomePage extends PageObject {
    private static final By signInBtn = By.className("login");

    public SignUpPage clickSignInButton() {
        this.open();
        clickOn($(signInBtn));

        return new SignUpPage();
    }

    public HomePage selectRootCategory(String rootCategory) {
        rootCategory = capitelizeOnlyFirstLetter(rootCategory);
        withAction().moveToElement($(By.xpath("//ul[contains(@class,'sf-menu')]/li/a[@title='" + rootCategory + "']"))).perform();

        return this;

    }

    public CategoryPage selectSubCategory(String subCategory) {
        subCategory = capitelizeOnlyFirstLetter(subCategory);
        clickOn($(By.xpath("//ul[contains(@class,'sf-menu')]/li/a[@title='Dresses']/../ul/li/a[@title='" + subCategory + "']")));

        return new CategoryPage();
    }
}
