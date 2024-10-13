package com.sivaramTest.RestAssuredTest;

public class Tofindtheindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "I have $100 rupees only";
		System.out.println(s.charAt(7));
		////to find the position of the string
		System.out.println(s.indexOf("$"));
		///to print the letter after particular index using substring
		System.out.println(s.substring(7));

	}

}
