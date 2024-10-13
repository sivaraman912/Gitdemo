package com.sivaramTest.RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
	

public class OAuthAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String S = given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://schema.getpostman.com/json/collection/v2.1.0/collection.json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
  System.out.println(S);
  
  JsonPath v = new JsonPath(S);
   String access = v.getString("access_token");
   
   String token = given().log().all().queryParam("access_token", "access")
   .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token")
   .then().log().all().assertThat().statusCode(200).extract().response().asString();
   System.out.println(token);
   
   
  
		
		
		

	}

}
