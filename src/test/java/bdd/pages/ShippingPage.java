package bdd.pages;

import net.serenitybdd.core.pages.PageObject;

public class ShippingPage extends PageObject {
    public void clickTermOfServiceBox() {
        getJavascriptExecutorFacade().executeScript("document.getElementById(\"cgv\").click()");
    }
}
