package com.test.CRUDWithTekarchApi;

import org.testng.annotations.Test;
import com.test.helpers.UserServiceHelpers;

public class CreateUserDataAPI extends UserServiceHelpers{
	
	@Test
	public void createUserDataTest() {
		createUserData();
	}
}
