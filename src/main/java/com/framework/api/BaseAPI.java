package com.framework.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {
	
	public RequestSpecification request;

    public RequestSpecification setup() {

        RestAssured.baseURI = "https://gorest.co.in";

        request = RestAssured
                .given()
                .header("Authorization",
                        "Bearer 2cb4d5e41a2c2d75e06cb4dff67ddc1a7eb962c3e2b1498c0f3f563d7338007d")
                .contentType("application/json");

        return request;
    }

}
