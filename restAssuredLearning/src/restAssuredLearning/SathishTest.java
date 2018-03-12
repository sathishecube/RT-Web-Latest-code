package restAssuredLearning;

import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SathishTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "https://reqres.in/api/users";
	 
			// Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();
	 
			// Make a request to the server by specifying the method Type and the method URL.
			// This will return the Response from the server. Store the response in a variable.
			Response response = httpRequest.request(Method.GET, "?/page=2");
	 
			// Now let us print the body of the message to see what response
			// we have recieved from the server
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
			//int statusCode = response.getStatusCode();
			String statusCode = response.getStatusLine();
			 
			// Assert that correct status code is returned.
			Assert.assertEquals(statusCode /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
			
			String contentType = response.header("Content-Type");
			System.out.println("Content-Type value: " + contentType);
		 
			// Reader header of a give name. In this line we will get
			// Header named Server
			String serverType =  response.header("Server");
			System.out.println("Server value: " + serverType);
		 
			// Reader header of a give name. In this line we will get
			// Header named Content-Encoding
			String acceptLanguage = response.header("Content-Encoding");
			System.out.println("Content-Encoding: " + acceptLanguage);
			
			Headers allHeaders = response.headers();
			 
			// Iterate over all the Headers
			for(Header header : allHeaders)
			{
				System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
			}
			
			
			// Retrieve the body of the Response
			ResponseBody body = response.getBody();
		 
			// By using the ResponseBody.asString() method, we can convert the  body
			// into the string representation.
			System.out.println("Response Body is: " + body.asString());
	 
		}
	 
	}
}