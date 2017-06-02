package org.fundacionjala.pivotal.cucumber.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.cucumber.assertions.Assertions;
import org.fundacionjala.pivotal.utils.RequestManager;

/**
 * Created by Administrator on 6/2/2017.
 */
public class RequestAccountStep {
    private Response response;

    /**
     * The method allows to retrieve a GET response.
     *
     * @param endpoint of String type.
     */
    @When("^I do a GET request to \"([^\"]*)\"$")
    public void getAccount(final String endpoint) {
        response = RequestManager.get(endpoint);
    }

    /**
     * The method verifies if the code status of the response
     * is 200.
     *
     * @param codeStatus of int type.
     */
    @Then("^I expect a (\\d+) status code.$")
    public void checkCodeResponse(final int codeStatus) {
        Assertions.isEqual(codeStatus, response.getStatusCode());
    }
}
