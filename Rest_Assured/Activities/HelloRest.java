package Examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 
public class HelloRest {
	
	String baseURI;
	@Test (priority =1)
	public void helloRest() {
		
		// Specify the base URL to the RESTful web service
        baseURI = "https://petstore.swagger.io/v2/pet";
 
        // Make a request to the server by specifying the method Type and 
        // resource to send the request to.
        // Store the response received from the server for later use.
        Response response = 
            given().contentType(ContentType.JSON) // Set headers
            .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request
 
     // Print the status code
//		System.out.println(response.statusCode());
//		System.out.println("===============================");
//		// Print the response headers
//		System.out.println(response.getHeaders().asList());
//		System.out.println("===============================");
//		// Print the response body
//		System.out.println(response.getBody().asString());
//		System.out.println("===============================");
//		System.out.println(response.getBody().asPrettyString());
        
        // Now let us print the body of the message to see what response
        // we have received from the server
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body is =>  " + responseBody);
        
        response.prettyPrint();
       // Extract properties from the response 
        String petStatus = response.then().extract().path("[0].status");
        
        // Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold")); 
		
	}
	@Test(priority =2)
		public void getResponseWithPathParm() {
		// Send request, get response, and assert
				RestAssured.given().  // Request Specification
					baseUri("https://petstore.swagger.io/v2/pet").
					header("Content-Type", "application/json"). // Request content type
					pathParam("petId", 12).
				when().get("/{petId}").
				then().
					statusCode(200).
					body("[0].status", Matchers.equalTo("sold")).
					body("[0].name", Matchers.equalTo("doggie"));
			
		}
}
