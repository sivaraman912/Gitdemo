package com.sivaramTest.RestAssuredTest;

public class Callingclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public static String addplace(String isbn, String aisle)
	{
		
		String s = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}";
				return s;
	}

}
