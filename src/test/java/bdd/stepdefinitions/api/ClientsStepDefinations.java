package bdd.stepdefinitions.api;

import bdd.Steps.api.ClientsSteps;
import bdd.services.BaseRestRequester;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

import static bdd.statics.Config.CLIENTS;
import static org.hamcrest.CoreMatchers.is;

public class ClientsStepDefinations extends BaseRestRequester {
    @Steps
    private ClientsSteps clientsSteps;

    @When("^Get all clients$")
    public void get_all_clients() {
        ValidatableResponse response = clientsSteps.getClients();
        setResponse(CLIENTS, response);
    }


    @Then("^User should see \"([^\"]*)\" in the client languages list$")
    public void user_should_see_in_the_client_languages_list(String client) {
        List<String> clients = getResponse(CLIENTS).extract().path("");
        Assert.assertThat(getResponse(CLIENTS).extract().statusCode(), is(200));
        Assert.assertTrue("" + client + " couldn't be found in clients" + client + " is not is client list", clients.contains(client));
    }

}
