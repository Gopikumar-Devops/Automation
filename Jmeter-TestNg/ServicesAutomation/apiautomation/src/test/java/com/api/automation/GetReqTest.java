package com.api.automation;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.List;




public class GetReqTest {

	@Test
	public void Test_1() {

		Response resp = given().param("q", "London,uk").param("appid", "b1b15e88fa797225412429c1c50c122a1").expect()
				.statusCode(200).when().get("http://samples.openweathermap.org/data/2.5/weather");

		String Actresult = resp.then().contentType(ContentType.JSON).extract().path("weather[0].description");
		if (Actresult.equalsIgnoreCase("light intensity drizzle")) {
			System.out.println("Passed " + Actresult);

		}
	}

	@Parameters("host")
	@Test
	public void Test_2(String server) {
		Response res = get(server+"/posts");
		assertEquals(200, res.getStatusCode());
		String json = res.asString();
		JsonPath jp = new JsonPath(json);
		List values = jp.get("id");
		for (int i = 0; i < values.size(); i++) {
			System.out.println("id: " + jp.get("id[" + i + "]"));
			System.out.println("title: " + jp.get("title[" + i + "]"));
			System.out.println("author: " + jp.get("author[" + i + "]"));

		}

		Assert.assertEquals(jp.get("title[0]"), "json-server");

	}
}
