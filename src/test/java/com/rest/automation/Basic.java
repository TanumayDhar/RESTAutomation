package com.rest.automation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectFiles.Resources;



public class Basic {
	//Requirement for GET response

	//Status code of the response
	//body
	//content type - xml or Json
	// header response - from which server
	
	
	Properties pr=new Properties();
	
	
	@BeforeTest
	public void setUp() throws IOException
	{

		FileInputStream fis =new FileInputStream("C:\\Users\\tanumay123\\Desktop\\REST API Testing(Automation) from scratch-Rest Assured java\\RestAPI_projects\\RESTAPIAutomationBasic\\src\\test\\java\\PageObjectFiles\\base.properties");

		pr.load(fis);


	}

	@Test
	public void RestTestAuto ()
	{


		//RestAssured.baseURI="https://reqres.in/api";

		//REST Assured is a Java library that provides a -
		//domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs. 
		//RestAssured.put();
		//RestAssured.get();
		//RestAssured.post();
		//RestAssured.when();


		RestAssured.baseURI=pr.getProperty("BASE_URL");

		given().
		when().
		//get("/users?page=2").
		
		get(Resources.getMethod()).
		
		
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
