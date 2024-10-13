package com.sivaramTest.RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class BusTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI="https://sivaramansj95.atlassian.net";
		String s = given().header("Contet-Type","application/json")
		.header("Authorization","Basic c2l2YXJhbWFuc2o5NUBnbWFpbC5jb206QVRBVFQzeEZmR0YwMzFLcHp5SjZrMUMtQkJPcU4wOEVxcDlIN1h3SWFEU0YyZTdWZTJELW9DZ2VVZFRGZVpLT2R1b0RNZVFsbzBXUlBKSXlEUzhJN0JpRFdibU9MWUlQZ0xyM1FOaDhZQUs1NnBaYUtpcDh6TjYwS2JHaGpGUkNEQk4zS01rTHRQYkhyS0x1MmtwRjFEd1JGZ1RnelRiNGMwNlNEUXBGaE9QOGNFbWRqd2szQXhJPTEyMjdDMUY5")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"RJ\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"issues\",\r\n"
				+ "       \"description\": \"Crnd issue type names using the REST API\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Task\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("rest/api/3/issue")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		
		JsonPath js = new JsonPath(s);
		String issueid = js.getString("id");
		System.out.println(issueid);
		System.out.println(issueid);
		
		//Add attachment to this jira
		
		given().header("X-Atlassian","no-check").pathParam("Key", issueid).header("Authorization","Basic c2l2YXJhbWFuc2o5NUBnbWFpbC5jb206QVRBVFQzeEZmR0YwMzFLcHp5SjZrMUMtQkJPcU4wOEVxcDlIN1h3SWFEU0YyZTdWZTJELW9DZ2VVZFRGZVpLT2R1b0RNZVFsbzBXUlBKSXlEUzhJN0JpRFdibU9MWUlQZ0xyM1FOaDhZQUs1NnBaYUtpcDh6TjYwS2JHaGpGUkNEQk4zS01rTHRQYkhyS0x1MmtwRjFEd1JGZ1RnelRiNGMwNlNEUXBGaE9QOGNFbWRqd2szQXhJPTEyMjdDMUY5")
		.header("Contet-Type","application/json")
		.multiPart("File",new File("C://Users//Shivarama//Pictures//Screenshots"))
		.log().all().when().post("rest/api/3/issue/{issueid}/attachments")
		.then().log().all().assertThat().statusCode(200).extract()
		.response().asString();
		
		
		
		
		
		
	}

}
