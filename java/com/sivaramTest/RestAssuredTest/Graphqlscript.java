package com.sivaramTest.RestAssuredTest;


import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class Graphqlscript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = given().log().all().header("Content-Type","application/json")
		.body("{\"query\":\"query($characterId: Int!,$episodeId: Int!)\\n{\\n  \\n  character(characterId: $characterId) {\\n    name\\n    gender\\n    status\\n    id\\n  }\\n  location(locationId: 8) {\\n    name\\n    dimension\\n  }\\n  episode(episodeId: $episodeId) {\\n    id\\n    name\\n  }\\n  characters(filters: {name: \\\"Rahul\\\"}) {\\n    info {\\n      count\\n    }\\n    result {\\n      name\\n      type\\n    }\\n  }\\n  episodes(filters: {episode: \\\"hulu\\\"}) {\\n    result {\\n      name\\n      air_date\\n      episode\\n      id\\n    }\\n  }\\n}\\n\",\"variables\":{\"characterId\":8,\"episodeId\":1}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = new JsonPath (s);
		String w = js.getString("data.character.name");
		System.out.println(w);
		
		
		
		
		

	}

}
