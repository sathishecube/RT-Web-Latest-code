package restAssuredLearning;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;





import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class restPost {
	public static void main(String[] args) throws JSONException {

	RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	RequestSpecification request = RestAssured.given();
 
	JSONObject requestParams = new JSONObject();
	requestParams.put("FirstName", "Virender"); // Cast
	requestParams.put("LastName", "Singh");
	requestParams.put("UserName", "sdimpleuser2dd2011");
	requestParams.put("Password", "password1");
 
	requestParams.put("Email",  "sample2ee26d9@gmail.com");
	request.body(requestParams.toJSONString());
	Response response = request.post("/register");
 
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, "200");
	String successCode = response.jsonPath().get("SuccessCode");
	Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	System.out.println("The status code recieved: " + statusCode);
	 
	System.out.println("Response body: " + response.body().asString());

}
}
