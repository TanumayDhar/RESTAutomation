package com.rest.automation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Basic {
											//Requirement for GET response
											
											//Status code of the response
											//body
											//content type - xml or Json
											// header response - from which server

	@Test
	public void RestTestAuto ()
	{
		
		
		RestAssured.baseURI="https://reqres.in/api";
		//REST Assured is a Java library that provides a -
		//domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs. 
		//RestAssured.put();
		//RestAssured.get();
		//RestAssured.post();
		//RestAssured.when();
		
		
		given().
				when().
				get("/users?page=2").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().log().all().
				and().
				body("data[0].email", equalTo("michael.lawson@reqres.in")).
				and().
				/*
				 * body("total_pages",equalTo("2")). and().
				 */
				header("Server", "cloudflare"); //validating form which server the data are coming//key and value
		
	
		
	}
	
	
}
