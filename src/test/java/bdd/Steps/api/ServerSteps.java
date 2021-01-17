package bdd.Steps.api;

import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

import static bdd.statics.Config.*;
import static net.serenitybdd.rest.RestRequests.given;

public class ServerSteps {

    @Step("Get Client Service")
    public ValidatableResponse getServers() {

        ValidatableResponse response = given()
                .when()
                .baseUri(API_BASE_URL)
                .get(SERVERS)
                .then();
        response.extract().response().prettyPrint();
        return response;
    }
}
