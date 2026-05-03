package com.framework.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.api.BaseAPI;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class APIUserTest extends BaseAPI {
	
	Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    int user_id;

    @Test
    public void getUser() {
    	
    	System.out.println("                       GET USER DETAILS            ");

        setup()
        .when()
            .get("/public/v2/users")
        .then()
            .statusCode(200)
            .log().body();
     System.out.println("==============================================================================");
    }

    @Test
    public void postUser() {
    	

        String payload = "{\n" +
                "  \"name\": \"Enakshi Pandey\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
        
        System.out.println("                ADD  USER DETAILS          ");

        Response response =
                setup()
                .body(payload)
                .when()
                .post("/public/v2/users");

        user_id = response.jsonPath().getInt("id");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("New ID Generated: " + user_id);
        System.out.println("==============================================================================");
        
    }

    @Test(dependsOnMethods = "postUser")
    public void putUser() {

        String payload = "{\n" +
                "  \"name\": \"Pandey\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"status\": \"inactive\"\n" +
                "}";
        System.out.println("                  UPDATE  USER  DETAILS           ");

        setup()
        .body(payload)
        .when()
        .put("/public/v2/users/" + user_id)
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
        .delete("/public/v2/users/" + user_id)
        .then()
        .statusCode(204);
        System.out.println("User Deleted");
        System.out.println("==============================================================================");
    }

}
