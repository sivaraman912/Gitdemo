package com.sivaramTest.RestAssuredTest;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Staticpayloadsusingfile {
	
	@Test()
	public static void addclass()
	
	{
		String s = RestAssured.baseURI= "http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json").
		body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Shivarama\\Downloads\\addplace.json"))))
		.when().post("Library/Addbook.php").then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String  n = js.getString("ID");
		System.out.println(n);

}
	
