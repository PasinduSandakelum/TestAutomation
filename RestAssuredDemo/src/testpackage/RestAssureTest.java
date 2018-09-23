package testpackage;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssureTest {
  @Test
  public void restAssuredGet() {
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  RequestSpecification reqGet = RestAssured.given();
	  Response resp = reqGet.request(Method.GET, "/colombo");
	  
	  String rbody = resp.getBody().asString();
	  System.out.println(rbody);
	  
  }
  
  @Test
  public void restAssuredTestPost() {
	  RestAssured.baseURI = "http://restapi.demoqa.com/customer";
	  RequestSpecification request = RestAssured.given();
	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("FirstName", "fname");
	  requestParams.put("LastName", "lname");
	  requestParams.put("UserName", "simpleUse001");
	  requestParams.put("Password", "1234");
	  requestParams.put("Email", "simpleemail@gmial.com");
	  
	  request.header("Content-Type", "application/json");
	  
	  request.body(requestParams.toJSONString());
//	  System.out.println(requestParams.toJSONString());
	  Response response = request.post("/register");
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  String successCode = response.jsonPath().get("SuccessCode");
	  Assert.assertEquals("Correct Success code was returned",successCode, "OPERATION SUCCESS");
	  
  }
}
