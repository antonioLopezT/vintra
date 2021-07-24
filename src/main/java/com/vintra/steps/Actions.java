package com.vintra.steps;

import com.vintra.data.Constants;
import com.vintra.models.User;
import com.vintra.service.ApiService;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class Actions extends ApiService {

    private StepData stepData;

    public Actions(StepData stepData) {
        this.stepData = stepData;
    }

    @When("I retrieve my authentication credentials")
    public void getUserCredentials() {
        RequestSpecification spec = getAuthContactsReqSpec(stepData.getToken());
        User user = get(spec, Constants.ME_URI)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);
        stepData.setUser(user);
    }

    @When("I logout")
    public void logout() {
        RequestSpecification spec = getAuthContactsReqSpec(stepData.getToken());
        get(spec, Constants.LOGOUT_URI)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
