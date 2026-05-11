package com.framework.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.api.BaseAPI;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class APIUserTest extends BaseAPI {
	
	Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String user_id;

    @Test
    public void getUser() {
    	
    	System.out.println("                       GET USER DETAILS            ");

        setup()
        .when()
            .get("/students")
        .then()
            .statusCode(200)
            .log().body();
     System.out.println("==============================================================================");
    }

    @Test
    public void postUser() {
    	

        String payload = "{\n" +
                "  \"name\": \"Enakshi Pandey\",\n" +
                "  \"location\": \"Chennai\",\n" +
                "  \"phone\": \"9876543210\",\n" +
                "  \"courses\": [\"Java\", \"Selenium\"]\n" +
                "}";
        
        System.out.println("                ADD  USER DETAILS          ");

        Response response =
                setup()
                .body(payload)
                .when()
                .post("/students");

        user_id = response.jsonPath().getString("id");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("New ID Generated: " + user_id);
        System.out.println("==============================================================================");
        
    }

    @Test(dependsOnMethods = "postUser")
    public void putUser() {

        String payload = "{\n" +
                "  \"name\": \"Pandey Updated\",\n" +
                "  \"location\": \"Bangalore\",\n" +
                "  \"phone\": \"9999999999\",\n" +
                "  \"courses\": [\"Playwright\", \"API Testing\"]\n" +
                "}";
        System.out.println("                  UPDATE  USER  DETAILS           ");

        setup()
        .body(payload)
        .when()
        .put("/students/" + user_id)
        .then()
        .statusCode(200)
        .log().body();
        System.out.println("==============================================================================");
    }

    @Test(dependsOnMethods = "putUser")
    public void deleteUser() {
    	
    	System.out.println("                       DELETE USER DETAILS             ");

        setup()
        .when()
        .delete("/students/" + user_id)
        .then()
        .statusCode(200);
        System.out.println("User Deleted");
        System.out.println("==============================================================================");
    }

}
