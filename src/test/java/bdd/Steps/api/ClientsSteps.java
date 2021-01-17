package bdd.Steps.api;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

import static bdd.statics.Config.API_BASE_URL;
import static bdd.statics.Config.CLIENTS;
import static net.serenitybdd.rest.RestRequests.given;

public class ClientsSteps {

    @Step("Get Client Service")
    public ValidatableResponse getClients() {

        ValidatableResponse response = given()
                .when()
                .baseUri(API_BASE_URL)
                .get(CLIENTS)
                .then();
        response.extract().response().prettyPrint();
        return response;
    }
}
