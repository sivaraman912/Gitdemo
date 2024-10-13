package com.sivaramTest.RestAssuredTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dynamicclass {
	
	@Test()
	public static void addclass()
	
	{
		String s = RestAssured.baseURI= "http://216.10.245.166";
		given().log().all().header("Content-Type","application/json").
		body(Callingclass.addplace("adfs","6445"))
		.when().post("Library/Addbook.php").then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(s);
		String  n = js.getString("ID");
		System.out.println(n);
		
		//Delete book scenario
		
		
		
		
		
		
		
		
	}
	
	@DataProvider(name="Books")
	public Object[][] getdata()
	{
		//arrary-collection of elements
		//multi dimensional arrary-collection of arrys
		return new Object[][] {{"shsh","2322"},{"dgsg","2421"}};
		
		
		
		
	}

}
