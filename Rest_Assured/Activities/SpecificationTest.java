package Examples;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationTest {
	// Declare Request and Response specifications objects
	
	RequestSpecification RequestSpec;
	ResponseSpecification ResponseSpec;
	int petId;
	
	@BeforeClass
	public void setUp() {
		// Create request specification
		RequestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type","application/json").
				build();
		
		// Create a response Specification
		ResponseSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectBody("status",equalTo("alive")).
				expectResponseTime(lessThanOrEqualTo(5000L)).
				build();
	}
	
	@Test(priority = 1)
	//POST https://petstore.swagger.io/v2/pet
	public void postRequestTest() {
		Map <String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 10234);
		reqBody.put("name", "Rocky");
		reqBody.put("status", "alive");
		// Send request and save the response
		Response response = given().spec(RequestSpec).body(reqBody).
							when().post();
		// Extract PetId from the response
		this.petId = response.then().extract().path("id");
		// Assertions
		response.then().spec(ResponseSpec);
		
	}
	//GET https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 2)
	public void getRequestTest() {
		// Send request, get request, Assert
		given().spec(RequestSpec).pathParam("petId",this.petId).
		when().get("/{petId}").
		then().spec(ResponseSpec).body("name",equalTo("Rocky"));
		
	}
	//DELETE https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void deleteRequestTest() {
		// Send request, get request, Assert
		given().spec(RequestSpec).pathParam("petId",this.petId).
		// log().all(). --> this prints all the values
		when().delete("/{petId}").
		then().statusCode(200);
		
	}
}
