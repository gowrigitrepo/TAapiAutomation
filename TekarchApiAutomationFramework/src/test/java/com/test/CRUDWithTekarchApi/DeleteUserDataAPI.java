package com.test.CRUDWithTekarchApi;

import org.testng.annotations.Test;

import com.test.helpers.UserServiceHelpers;

public class DeleteUserDataAPI extends UserServiceHelpers{
	@Test
	public void deleteUserDataTest() {
		deleteUserData();
	}

}
