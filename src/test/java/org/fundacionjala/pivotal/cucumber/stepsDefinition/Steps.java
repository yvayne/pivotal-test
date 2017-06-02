package org.fundacionjala.pivotal.cucumber.stepsDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Map;
import org.fundacionjala.pivotal.cucumber.assertions.Assertions;
import org.fundacionjala.pivotal.utils.api.RequestManager;

import static io.restassured.path.json.JsonPath.from;

/**
 * Created by Ruber Cuellar on 6/2/2017.
 */
public class Steps {

    private Response response;
    private Map<String, ?> project;

    /**
     * To request POST.
     * @param endpoint The endpoint to send
     * @param body The body to send
     */
    @When("^I request POST \"([^\"]*)\" with:$")
    public void requestPost(final String endpoint, final Map<String, String> body) {
        response = RequestManager.post(endpoint, body);
    }

    /**
     * Commented.
     */
    @Then("New worksapce should be successful")
    public void newWorkspaceShouldSuccessful() {
        System.out.println(response.prettyPrint());
    }


    /**
     * To get project object by name.
     * @param name The name to search
     * @return Map<String, ?></>
     */
    public Map<String, ?> getProjectObjectByName(final String name) {
        ArrayList<Map<String, ?>> jsonArr = from(response.asString()).get("");
        for (Map<String, ?> obj : jsonArr) {
            if (obj.get("name").toString().equals(name)) {
                return obj;
            }
        }
        return null;
    }

    /**
     * To store project.
     */
    @And("^I stored project$")
    public void storageProject() {
        project = from(response.asString()).get("");
    }

    /**
     * To verify if a project exists. This method needs to be improved.
     * @return boolean
     */
    @Then("^I verify the project exists$")
    public boolean verifyProjectExists() {
        ArrayList<Map<String, ?>> jsonArr = from(response.asString()).get("");
        for (Map<String, ?> obj : jsonArr) {
            if (obj.get("name").toString().equals(project.get("name"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * To build endpoint.
     * @param endpoint The endpoint to build.
     * @return String
     */
    public String buildEndpoint(final String endpoint) {
        String newEndpoint = "";
        if (endpoint.contains("[projectid]")) {
            newEndpoint = endpoint.replace("[projectid]", project.get("id").toString());
        } else {
            newEndpoint = endpoint;
        }
        return newEndpoint;
    }

    /**
     * To send GET request.
     * @param endpoint The endpoint to send
     */
    @When("^I request GET \"([^\"]*)\"$")
    public void requestGet(final String endpoint) {
        response = RequestManager.get(buildEndpoint(endpoint));
    }

    /**
     * To send DELETE request.
     * @param endpoint The endpoint to send.
     */
    @Then("^I request DELETE \"([^\"]*)\"$")
    public void requestDelete(final String endpoint) {
        response = RequestManager.delete(buildEndpoint(endpoint));
    }


    /**
     * To get expect status code.
     * @param statusCode The endpoint to send
     */
    @Then("^I expect status code (\\d+)$")
    public void expectedStatus(final int statusCode) {
        Assertions.equals(response.getStatusCode(), statusCode);
    }

    /**
     * To send PUT request.
     * @param endpoint The endpoint to send
     * @param body The body to send
     */
    @When("^I request PUT \"([^\"]*)\" with:$")
    public void requestPut(final String endpoint, final Map<String, String> body)  {
        response = RequestManager.put(buildEndpoint(buildEndpoint(endpoint)), body);
    }
}
