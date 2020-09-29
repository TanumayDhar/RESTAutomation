package com.rest.automation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.UnsupportedEncodingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddandDelete {


	@Test
	public void addDelete() throws UnsupportedEncodingException
	{

		RestAssured.baseURI="https://reqres.in/api";

		Response res =given().

				//Task 1 - grab the response
				when().

				get("/users/2").

				then().assertThat().statusCode(200).and().

				extract().response();

		String responsevariable= res.asString();
		System.out.println("user details"+ responsevariable);



		//Task 2 - 	convert the response to jason  as it extracted as raw value.


		JsonPath jsonconvert=new JsonPath(responsevariable);

		String firstName=jsonconvert.get("data.first_name");

		System.out.println(firstName);


		//Task 3 - 	Delete the user

		given().
		
			when().
			
			delete("/users/2").
			
			then().assertThat().statusCode(204);
			
			
			





	}



}
