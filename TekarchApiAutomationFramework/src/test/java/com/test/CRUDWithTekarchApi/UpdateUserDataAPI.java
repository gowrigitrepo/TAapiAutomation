package com.test.CRUDWithTekarchApi;

import org.testng.annotations.Test;
import com.test.helpers.UserServiceHelpers;

public class UpdateUserDataAPI extends UserServiceHelpers{

	@Test
	public void updateUserDataTest() {
		updateUserData();
	}
	
}
