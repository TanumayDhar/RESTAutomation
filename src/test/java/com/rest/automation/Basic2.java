package com.rest.automation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;



public class Basic2 {
	
	@Test
	public void postTest()
	{
		
		RestAssured.baseURI="https://reqres.in/api";
		
		given().
		
		
		body("\"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"").
		
		when().
		
		post("/users").
		
		then().assertThat().statusCode(201).and().log().all().
		and().contentType(ContentType.JSON);
		
	
	
			
	
			
			
			
		
		
		
		
		
		
	}

	private RequestSpecification post(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private RestAssured when() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
