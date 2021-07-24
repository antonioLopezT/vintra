package com.vintra.service;

import com.vintra.data.Constants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    protected Response get(RequestSpecification spec,  String endpoint) {
        return RestAssured.given().spec(spec).get(endpoint);
    }

    protected Response put(RequestSpecification spec,  String endpoint) {
        return RestAssured.given().spec(spec).put(endpoint);
    }

    protected Response post(RequestSpecification spec,  String endpoint) {
        return RestAssured.given().spec(spec).post(endpoint);
    }

    protected RequestSpecification getContactsReqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_URI)
                .setAccept(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    protected RequestSpecification getAuthContactsReqSpec(String token) {
        return getContactsReqSpec().auth().oauth2(token);
    }
}
