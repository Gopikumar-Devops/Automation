package stepdefs;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.StringUtils;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class DemoTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_PROFILE = "http://localhost:3000/posts/";
	
	@Given("profile of an author with id one exists in the system$")
	public void profile_of_an_author_with_id_one_exists_in_the_system$(){
		request = given().param("id", 1 );

	}
	
	@When("a user retrieves the profile by id$") 
	public void a_user_retrieves_the_profile_by_id$(){
		response = request.when().get(ENDPOINT_GET_PROFILE);
		System.out.println("response: " + response.prettyPrint());
	}
	
	@Then("the status code should be (\\d+)$")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}
	
	@And("response contains the following details$")
	public void response_contains(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}
	}
	
	
	

}
