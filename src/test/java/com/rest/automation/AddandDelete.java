package com.rest.automation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class AddandDelete {
	
Properties pr=new Properties();
	
	
	@BeforeTest
	public void setUp() throws IOException
	{

		FileInputStream fis =new FileInputStream("C:\\Users\\tanumay123\\Desktop\\REST API Testing(Automation) from scratch-Rest Assured java\\RestAPI_projects\\RESTAPIAutomationBasic\\src\\test\\java\\Resources\\base.properties");

		pr.load(fis);

	}


	@Test
	public void addDelete() throws UnsupportedEncodingException
	{

		RestAssured.baseURI=pr.getProperty("BASE_URL");

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
