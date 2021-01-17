package bdd.stepdefinitions.api;

import bdd.Steps.api.ServerSteps;
import bdd.services.BaseRestRequester;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

import static bdd.statics.Config.SERVERS;
import static org.hamcrest.CoreMatchers.is;

public class ServersStepDefinations extends BaseRestRequester {

    @Steps
    private ServerSteps serverSteps;

    @When("^Get all servers$")
    public void get_all_servers() {
        ValidatableResponse response = serverSteps.getServers();
        setResponse(SERVERS, response);
    }


    @Then("^User should see \"([^\"]*)\" in the server languages list$")
    public void user_should_see_in_the_server_languages_list(String server) {
        List<String> servers = getResponse(SERVERS).extract().path("");
        Assert.assertThat(getResponse(SERVERS).extract().statusCode(), is(200));
        Assert.assertTrue("" + server + " couldn't be found in servers" + server + " is not is server list", servers.contains(server));
    }

}
