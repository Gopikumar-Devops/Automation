package com.api.automation;

import com.api.automation.DataPost;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

import java.util.HashMap;

public class PostReqTest {

	@Parameters("host")
	@Test
	public void Test_01(String server) {
		Response resp = given()
				.body("{\"id\":\"8\"," + "\"title\":\"dummyTitle\"," + "\"author\":\"Demo\"}")
				.when()
				.contentType(ContentType.JSON)
				.post(server+"/posts");
		System.out.println(resp.asString());
	}


	@Test
	public void Test_02(){
		DataPost post=new DataPost();
		post.setId("5");
		post.setAuthor("upRAM");
		post.setTitle("BOOK"); 

		Response resp = given()
				.when()
				.body(post)
				.contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println(resp.asString());
		
	}
	
	@Test
	public void Test_03(){
		HashMap<String, String> authentication =new HashMap<>();
		authentication.put("id","10");
		authentication.put("title","authentication");
		authentication.put("author","john");

		Response resp = given()
				.when()
				.body(authentication)
				.contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println(resp.asString());
		
	}
	
	 
}


