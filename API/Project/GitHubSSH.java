package restassuredproject;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubSSH {
	 String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIP7EitZ8FzO6exZnKHQLeFk9sU4XW+47c6fjmjjA17G1"; // Replace with your actual public key
	 int sshKeyId;
	// Declare request specification
	RequestSpecification requestSpec;
	 
	@BeforeClass
	public void setUp() {	    // Create request specification
	    requestSpec = new RequestSpecBuilder()
	        .setContentType(ContentType.JSON)
	        .setBaseUri("https://api.github.com")
	        .addHeader("Authorization", "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")
	        .build();
	    
	}
	
	@Test(priority = 1)
    public void postRequestTest() {
        // Create request body as String
        String requestBody =sshKey;
        Response response=given()
        		.spec(requestSpec)
        		.body(requestBody)
        		.when()
        		.post("/user/keys");
        sshKeyId = response.then().extract().path("id");
        response.then()
        .statusCode(201);
	}
	
	@Test(priority =2,dependsOnMethods = "postRequestTest")
	public void getRequestTest() 
	{
		 Response response = given()
	                .spec(requestSpec)
	                .pathParam("keyId", sshKeyId)
	            .when()
	                .get("/user/keys/{keyId}");
		 System.out.println("GET Response: " + response.asPrettyString());
	        Reporter.log("GET Response for Key ID " + sshKeyId + ": " + response.asString());
	        response.then()
            .statusCode(200);
	}
	        
	        @Test(priority = 3, dependsOnMethods = "postRequestTest")
	        public void deleteRequestTest() {
	            // Send DELETE request using path parameter for keyId
	            Response response = given()
	                    .spec(requestSpec)
	                    .pathParam("keyId", sshKeyId)
	                .when()
	                    .delete("/user/keys/{keyId}");

	            // Print status to console and TestNG report
	            System.out.println("DELETE Request status: " + response.getStatusCode());
	            Reporter.log("DELETE Request for Key ID " + sshKeyId + " returned status: " + response.getStatusCode());

	            // Assertions: Check status code 204
	            response.then()
	                    .statusCode(204);
	        }
		
	
}
