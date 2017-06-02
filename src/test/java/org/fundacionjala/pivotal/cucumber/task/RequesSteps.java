package org.fundacionjala.pivotal.cucumber.task;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.utils.api.RequestManager;

import java.util.Map;

import static io.restassured.path.json.JsonPath.from;

/**
 * Created by Administrator on 6/1/2017.
 */
public class RequesSteps {

  private Response response;
  private Map<String, ?> project;

  /**
   * To request POST.
   * @param endpoint The endpoint to send
   * @param body The body to send
   */
  @When("^I request POST \"([^\"]*)\" with:$")
  public void iRequestPOSTWith(final String endpoint, final Map<String, String> body) {
    response = RequestManager.post(endpoint, body);
  }

  /**
   * Store project.
   */
  @And("^I stored project$")
  public void storageProject() {
    project = from(response.asString()).get("");
    System.out.println(project);
  }

  /**
   * Store storie.
   */
  @And("^I stored storie$")
  public void storageStorie() {
    project = from(response.asString()).get("");
  }

  /**
   * To send GET request.
   * @param endpoint The endpoint to send
   */
  @When("^I request GET \"([^\"]*)\"$")
  public void iRequestGETWith(final String endpoint) {
    response = RequestManager.get(buildEndpoint(endpoint));
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
   * To get expect status code.
   * @param statusCode The endpoint to send
   */
  @Then("^I expect status code (\\d+)$")
  public void expectedStatus(final int statusCode) {
    Assertions.equals(response.getStatusCode(), statusCode);
  }

  /**
   * Method to show the task successful.
   */
  @And("The task should be successful")
  public void newTaskShouldSuccessful() {
    System.out.println(response.prettyPrint());
  }
}
