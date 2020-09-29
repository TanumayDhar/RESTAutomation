package com.rest.automation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import PageObjectFiles.Payload;
import PageObjectFiles.Resources;




public class Basic2 {



	Properties ps =new Properties();

	@BeforeTest
	public void baseSetup() throws IOException
	{

		FileInputStream fis =new FileInputStream("C:\\Users\\tanumay123\\Desktop\\REST API Testing(Automation) from scratch-Rest Assured java\\RestAPI_projects\\RESTAPIAutomationBasic\\src\\test\\java\\PageObjectFiles\\base.properties");

		ps.load(fis);


		//ps.getProperty("BASE_URL");
	}


	@Test
	public void postTest()
	{

		RestAssured.baseURI=ps.getProperty("BASE_URL");

		given().


		body(Payload.postBody()).

		when().

		//post("/users").
		post(Resources.postMethod()).

		then().assertThat().statusCode(201).and().log().all().
		and().contentType(ContentType.JSON);



	}



}
