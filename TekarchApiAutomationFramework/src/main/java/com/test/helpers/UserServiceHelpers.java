package com.test.helpers;

import org.hamcrest.Matchers;

import com.test.constants.EndPoints;
import com.test.constants.SourcePath;
import com.test.models.ReadUserDataPOJO;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserServiceHelpers extends ReusableMethods{

	protected static Response response;
	static Header header;
	protected static String token;
	static int statusCode;
	protected static ReadUserDataPOJO[] listOfUsers;
	static RequestSpecification reqSpec;
	
	public void setUpRequestSpecification() {
		reqSpec=new RequestSpecBuilder()
		.addHeader("Content-Type", "application/json")
		.setBaseUri(getBaseURI())
		.build();
	}
	
	public String getBaseURI() {
		return SourcePath.URI;
	}
	
	public String getToken() {
		System.out.println("Inside getToken()");
		response=loginToAPI();
		token = response.jsonPath().getString(SourcePath.JSON_PATH_FIRST_TOKEN);
		return token;
	}
	
	public String getToken(Response response) {
		token = response.jsonPath().getString(SourcePath.JSON_PATH_FIRST_TOKEN);
		return token;
	}
	
	public int getStatusCode() {
		response=loginToAPI();
		statusCode = response.getStatusCode();
		return statusCode;
	}
	
	public void validatableResponse() {
		
	}
	
	public ValidatableResponse verifyStatusCode(Response response,int statusCode) {
		return response.then().statusCode(statusCode);
	}
	
	public void validateResponseTime(Response response) {
		response.then().time(Matchers.lessThan(500l));
	}
	public ValidatableResponse schemaValidator(Response response,String schemaName) {
		return response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaName));
	}
	
	public Response loginToAPI() {
		response = RestAssured.given().contentType(ContentType.JSON)
				.body(getUserLogin())
				//.body(SourcePath.USER_LOGIN_JSON)
				.when()
				.post(EndPoints.LOGIN_RESOURCE);
		return response;
	}

	public ReadUserDataPOJO[] readUserData() {
		header = new Header("token",getToken());
		response = RestAssured.given().header(header)
				.when()
				.get(EndPoints.GET_DATA_RESOURCE);
		verifyStatusCode(response, SourcePath.STATUS_CODE_200);
		schemaValidator(response,"getUserDataSchema.json");
		ReadUserDataPOJO[] listOfUsers = response.as(ReadUserDataPOJO[].class);
		return listOfUsers;
	}
	
	public ReadUserDataPOJO[] readUserDataWithToken(String token) {
		header = new Header("token",token);
		response = RestAssured.given().header(header)
				.when()
				.get(EndPoints.GET_DATA_RESOURCE);
		verifyStatusCode(response, SourcePath.STATUS_CODE_200);
		schemaValidator(response,"getUserDataSchema.json");
		ReadUserDataPOJO[] listOfUsers = response.as(ReadUserDataPOJO[].class);
		return listOfUsers;
	}
	
	public Response createUserData() {
		header = new Header("token",getToken());
		response = RestAssured.given()
				.header(header)
				.contentType(ContentType.JSON)
				//.body(getUserDataToAdd())
				.body(SourcePath.CREATE_USER_DATA_JSON)
				.when()				
				.post(EndPoints.CREATE_DATA_RESOURCE);
		return response;
	}
	
	public Response createUserDataWithToken(String token) {
		header = new Header("token",token);
		response = RestAssured.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(getUserDataToAdd())
				.when()				
				.post(EndPoints.CREATE_DATA_RESOURCE);
		return response;
	}
	
	public Response updateUserData() {
		header = new Header("token",getToken());
		response = RestAssured.given()
				.header(header)
				.contentType(ContentType.JSON)
				//.body(getUserDataToUpdate())
				.body(SourcePath.UPDATE_USER_DATA_JSON)
				.when()				
				.put(EndPoints.UPDATE_DATA_RESOURCE);
		return response;
	}
	
	public Response updateUserDataWithValues(String token,String department,String id) {
		header = new Header("token",token);
		response = RestAssured.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(getUserDataToUpdate(department,id))
				.when()				
				.put(EndPoints.UPDATE_DATA_RESOURCE);
		return response;
	}
	
	public Response deleteUserData() {
		header = new Header("token",getToken());
		response = RestAssured.given()
				.header(header)
				.contentType(ContentType.JSON)
				//.body(getUserDataToDelete())
				.body(SourcePath.DELETE_USER_DATA_JSON)
				.when()				
				.delete(EndPoints.DELETE_DATA_RESOURCE);
		return response;
	}
	
	public Response deleteUserDataWithValues(String token,String id) {
		header = new Header("token",token);
		response = RestAssured.given()
				.header(header)
				.contentType(ContentType.JSON)
				.body(getUserDataToDelete(id))
				.when()				
				.delete(EndPoints.DELETE_DATA_RESOURCE);
		return response;
	}
}
