package com.test.CRUDWithTekarchApi;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.test.helpers.UserServiceHelpers;

import io.restassured.RestAssured;


public class LoginToAPI extends UserServiceHelpers {	
	
	@BeforeMethod
	public void init() {
		RestAssured.baseURI = getBaseURI();
	}
	
	@Test
	public void loginToApiTest() {
		System.out.println("Login test - Start");
		//response = loginToAPI();
		System.out.println("Token Value : "+getToken());
	}
}
