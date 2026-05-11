package com.framework.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	public RequestSpecification request;

    public RequestSpecification setup() {

        RestAssured.baseURI = "http://localhost:3000";

        request = RestAssured
                .given()
                .contentType("application/json");

        return request;
    }

}
