package com.vintra.steps;

import com.vintra.data.Constants;
import com.vintra.service.ApiService;
import io.cucumber.java.en.Then;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class Assertions extends ApiService {

    private StepData stepData;

    public Assertions(StepData stepData) {
        this.stepData = stepData;
    }

    /**
     * Step definition that assert if the values of an authentication credentials are valid
     */
    @Then("I should be able to check that my authentication credentials are valid")
    public void checkUserCredentials() {
        Assert.assertNotNull(stepData.getUser(), "Authentication credentials not found");
        Assert.assertEquals(stepData.getUser().getUsername(), stepData.getUsername(), "Username does not match");
        Assert.assertTrue(stepData.getUser().getId() > 0, "User id should be a positive number");
        Assert.assertTrue(stepData.getUser().getEmail().contains(stepData.getUsername()), "The email should contain the username");
        Assert.assertFalse(stepData.getUser().isDisabled(), "A newly created user should be always enable by default");
    }

    /**
     * Step definition that assert if the get authentication credentials endpoint returns a HTTP 401 if the user has logged out
     */
    @Then("I should receive an unauthorized response")
    public void checkUnauthorized() {
        RequestSpecification spec = getAuthContactsReqSpec(stepData.getToken());
        get(spec, Constants.ME_URI)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
