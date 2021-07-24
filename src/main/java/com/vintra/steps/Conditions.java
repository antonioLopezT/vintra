package com.vintra.steps;

import com.vintra.data.Constants;
import com.vintra.service.ApiService;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class Conditions extends ApiService {

    private StepData stepData;

    public Conditions(StepData stepData) {
        this.stepData = stepData;
    }

    /**
     * Step definition to login a user with specific username and password
     *
     * @param username username
     * @param password password
     */
    @Given("That I am a logged in user with {string} as username and {string} as password")
    public void logInUser(String username, String password) {
        RequestSpecification spec = getContactsReqSpec()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", username)
                .formParam("password", password);
        String token = post(spec, Constants.LOGIN_URI)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath().getString("access_token");
        stepData.setUsername(username);
        stepData.setToken(token);
    }

}
