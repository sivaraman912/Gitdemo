package com.sivaramTest.RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class APIAUTOMATION {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//add place api working or not
		String newaddress = "70 winter walk, USA";
		
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().queryParam("key", "qaclick123").header("content-type","application/json")
	.body("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Rahul Shetty Academy\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}\r\n"
			+ "").when().post("maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
	.extract().response().asString();
	
	JsonPath js=new JsonPath(response);
	String rest=js.getString("place_id");
	System.out.println(rest);
	
	
	
	//Add place -->update place with new address--Get place to validate if new address is present in response--
	
	given().log().all().queryParam("key", "qaclick123").header("content-type","application/json")
	.body("{\r\n"
			+ "\"place_id\""+rest+"\",\r\n"
			+ "\"address\":\"70 winter walk, USA\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "").when().put("maps/api/place/update/json")
	.then().log().all().assertThat().statusCode(200);
	
	String place = given().log().all().queryParam("place_id",rest).when().get("maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath jsl = new JsonPath(place);
	String success = jsl.getString("address");
	System.out.println(success);
	Assert.assertEquals(success, newaddress);
	//cucumber junit,testng
	
	
	
	
	
	

	}

}
