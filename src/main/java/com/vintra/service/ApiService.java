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

    /**
     * Make a GET request to an specific endpoint
     *
     * @param spec     {@link RequestSpecification}
     * @param endpoint URL
     * @return {@link Response}
     */
    protected Response get(RequestSpecification spec, String endpoint) {
        return RestAssured.given().spec(spec).get(endpoint);
    }

    /**
     * Make a PUT  request to an specific endpoint
     *
     * @param spec     {@link RequestSpecification}
     * @param endpoint URL
     * @return {@link Response}
     */
    protected Response put(RequestSpecification spec, String endpoint) {
        return RestAssured.given().spec(spec).put(endpoint);
    }

    /**
     * Make a POST  request to an specific endpoint
     *
     * @param spec     {@link RequestSpecification}
     * @param endpoint URL
     * @return {@link Response}
     */
    protected Response post(RequestSpecification spec, String endpoint) {
        return RestAssured.given().spec(spec).post(endpoint);
    }

    /**
     * Get a basic {@link RequestSpecification} with out authentication
     *
     * @return {@link RequestSpecification}
     */
    protected RequestSpecification getContactsReqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_URI)
                .setAccept(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    /**
     * Get an authenticated {@link RequestSpecification}
     *
     * @param token bearer token
     * @return {@link RequestSpecification}
     */
    protected RequestSpecification getAuthContactsReqSpec(String token) {
        return getContactsReqSpec().auth().oauth2(token);
    }
}
