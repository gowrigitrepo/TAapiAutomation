package com.test.CRUDWithTekarchApi;

import org.testng.annotations.Test;

import com.test.helpers.UserServiceHelpers;
import com.test.models.ReadUserDataPOJO;

public class ReadUserDataAPI extends UserServiceHelpers{
	@Test
	public void readUserDataTest() {
		ReadUserDataPOJO[] listOfUsers = readUserData();
		System.out.println("Account number [0] : "+listOfUsers[0].getAccountno());
		System.out.println("User ID [0] : "+listOfUsers[0].getUserid());
		System.out.println("ID [0] : "+listOfUsers[0].getId());
		
	}
}
