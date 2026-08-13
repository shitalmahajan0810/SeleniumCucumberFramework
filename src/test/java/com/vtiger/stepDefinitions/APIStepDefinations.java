package com.vtiger.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;


public class APIStepDefinations {

    String endpoint;
    Response response;

    String reqBody = """
            {
              "id": 0,
              "title": "Apple",
              "price": 100000.0,
              "description": "Iphone",
              "category": "mobile",
              "image": "http://example.com"
            }
            """;

    String putReqBody = """
            {"title": "Samsung", "price": 50.99}
            """;


    @Given("endpoint is {string}")
    public void endpoint_is(String endpoint) {
        this.endpoint = endpoint;

    }

    @When("user send GET request")
    public void user_send_get_request() {
        this.response = RestAssured.given().get(endpoint);
    }

    @Then("status code is {int}")
    public void status_code_is(Integer status) {

        System.out.println(response.statusCode());
        ;
        response.then().statusCode(status);

        // System.out.println(response.asPrettyString());


    }

    @Then("validate response product details")
    public void validate_response_product_details() {

        response.then()
                .body("title", everyItem(notNullValue()))
                .body("price", everyItem(notNullValue()))
                .body("category", everyItem(notNullValue()));


        // response.then().body("description", everyItem(notNullValue()));

        response.then()
                .body("[0].id", equalTo(1));

        ;
        //System.out.println(response.jsonPath().get("[0]"));

        System.out.println(response.jsonPath().get("[0]").toString());
        System.out.println(response.jsonPath().get("[1].id").toString());
        System.out.println(response.jsonPath().getInt("[0].id"));

        response.then()
                .body("[0].title",
                        equalTo("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"));

        response.then().body("[0].id", instanceOf(Integer.class));
        response.then().body("[0].title", not(instanceOf(Integer.class)));


        System.out.println(response.jsonPath().get("[1].rating.rate").toString());

    }

    @Then("validate response of single product")
    public void validate_response_single_product() {
        response.prettyPrint();

        System.out.println(response.jsonPath().get("id").toString());
        System.out.println(response.jsonPath().getInt("id"));

        response.then()
                .body("id", instanceOf(Integer.class))
                .body("id", (notNullValue()))
                .body("title", not(instanceOf(Integer.class)))
                .body("title", (notNullValue()))
                .body("price", instanceOf(Float.class))
                .body("price", (notNullValue()))
                .body("description", (notNullValue()))
                .body("category", (notNullValue()))
                .body("image", instanceOf(String.class));

        System.out.println(response.jsonPath().getInt("id"));
        System.out.println(response.jsonPath().get("title").toString());
        System.out.println(response.jsonPath().getFloat("price"));
        System.out.println(response.jsonPath().get("category").toString());

    }


    @When("user send POST request")
    public void user_send_post_request() {


        response = RestAssured.given() .contentType("application/json").body(reqBody).log().all().post(endpoint);

        response.prettyPrint();


    }

    @Then("validate response of newly created product")
    public void validate_response_of_newly_created_product() {

    }

    @When("user send PUT request")
    public void user_send_put_request() {
        response = RestAssured.given() .contentType("application/json").body(putReqBody).put(endpoint);
    }

    @Then("validate response of updated product")
    public void validate_response_of_updated_product() {
        response.prettyPrint();

    }

    @When("user send DELETE request")
    public void user_send_delete_request() {
        response = RestAssured.given().contentType("application/json").delete(endpoint);

    }
    @Then("validate response of deleted product")
    public void validate_response_of_deleted_product() {

        response.prettyPrint();
    }

}