package bdd.services;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

public class BaseRestRequester {

    private static Map<String, ValidatableResponse> multipleResponse = new HashMap<>();

    public ValidatableResponse getResponse(String testName) {
        return multipleResponse.get(testName);
    }

    public void setResponse(String endpoint, ValidatableResponse response) {
        multipleResponse.put(endpoint, response);
    }
}
