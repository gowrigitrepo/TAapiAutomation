package com.test.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.constants.SourcePath;
import com.test.helpers.UserServiceHelpers;
import com.test.models.ReadUserDataPOJO;
import com.test.models.UpdateUserDataPOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTestScriptEndToEnd extends UserServiceHelpers {

	@BeforeMethod
	public void init() {
		RestAssured.baseURI = getBaseURI();
	}

	@Test(priority = 1)
	public void validLogin() {
		response = loginToAPI();
		verifyStatusCode(response, SourcePath.STATUS_CODE_201);
		//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("loginResponseSchema.json"));
		schemaValidator(response, "loginResponseSchema.json");
		token = getToken(response);
		System.out.println("Token Value : " + token);
		// return token;
	}

	// (enabled = false)
	@Test(priority = 2)
	public void readUserDataTestE2E() {
		listOfUsers = readUserDataWithToken(token);
		System.out.println("Inside - readUserDataTestE2E(): Account No = " + listOfUsers[0].getAccountno());
		System.out.println("Inside - readUserDataTestE2E(): Department = " + listOfUsers[0].getDepartmentno());
		System.out.println("User ID[0] : " + listOfUsers[0].getUserid());
		System.out.println("Id[0] : " + listOfUsers[0].getId());
		// return listOfUsers;
	}

	// (enabled = false)
	@Test(priority = 3)
	public void createUserDataTestE2E() {
		response = createUserDataWithToken(token);
		verifyStatusCode(response, SourcePath.STATUS_CODE_201);
		//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("successSchema.json"));
		schemaValidator(response, "successSchema.json");
		System.out.println("Token Value createUserDataTestE2E() :" + token);
		listOfUsers = readUserDataWithToken(token);
		System.out.println("Inside - createUserDataTestE2E(): Account No = " + listOfUsers[0].getAccountno());
		System.out.println("Inside - createUserDataTestE2E(): Department = " + listOfUsers[0].getDepartmentno());
		System.out.println("User ID[0] : " + listOfUsers[0].getUserid());
		System.out.println("Id[0] : " + listOfUsers[0].getId());
		// return response;
	}

	// (enabled = false)
	@Test(priority = 4)
	public void updateUserDataTestE2E() {
		System.out.println("Token Value updateUserDataTestE2E() :" + token);
		String id = listOfUsers[0].getId();
		response = updateUserDataWithValues(token, "2", id);
		verifyStatusCode(response, SourcePath.STATUS_CODE_200);
		//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("successSchema.json"));
		schemaValidator(response, "successSchema.json");
		listOfUsers = readUserDataWithToken(token);
		System.out.println("Inside - updateUserDataTestE2E(): Account No = " + listOfUsers[0].getAccountno());
		System.out.println("Inside - updateUserDataTestE2E(): Department = " + listOfUsers[0].getDepartmentno());
		System.out.println("User ID[0] : " + listOfUsers[0].getUserid());
		System.out.println("Id[0] : " + listOfUsers[0].getId());
	}

	// (enabled = false)
	@Test(priority = 5)
	public void deleteUserDataTestE2E() {
		System.out.println("Token Value deleteUserDataTestE2E() :" + token);
		String id = listOfUsers[0].getId();
		response = deleteUserDataWithValues(token, id);
		verifyStatusCode(response, SourcePath.STATUS_CODE_200);
		//response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("successSchema.json"));
		schemaValidator(response, "successSchema.json");
		listOfUsers = readUserDataWithToken(token);
		System.out.println("Inside - deleteUserDataTestE2E(): Account No = " + listOfUsers[0].getAccountno());
		System.out.println("Inside - deleteUserDataTestE2E(): Department = " + listOfUsers[0].getDepartmentno());
		System.out.println("User ID[0] : " + listOfUsers[0].getUserid());
		System.out.println("Id[0] : " + listOfUsers[0].getId());
	}

}
