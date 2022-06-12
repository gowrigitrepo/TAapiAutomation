package com.test.helpers;

import com.test.constants.SourcePath;
import com.test.models.CreateUserDataPOJO;
import com.test.models.DeleteUserDataPOJO;
import com.test.models.LoginToApiPOJO;
import com.test.models.ReadUserDataPOJO;
import com.test.models.UpdateUserDataPOJO;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReusableMethods {

	protected static UpdateUserDataPOJO updateUser;
	
	public LoginToApiPOJO getUserLogin() {
		System.out.println("Inside getUserLogin()");
		LoginToApiPOJO loginPOJO = new LoginToApiPOJO();
		loginPOJO.setUsername(SourcePath.USER_NAME);
		loginPOJO.setPassword(SourcePath.PASSWORD);
		return loginPOJO;
	}

	public CreateUserDataPOJO getUserDataToAdd() {
		CreateUserDataPOJO createUser = new CreateUserDataPOJO();
		createUser.setAccountno("TA-GV11122");
		createUser.setDepartmentno("1");
		createUser.setSalary("111");
		createUser.setPincode("112212");
		return createUser;
	}

	public UpdateUserDataPOJO getUserDataToUpdate() {
		updateUser = new UpdateUserDataPOJO();
		updateUser.setAccountno("TA-GV11122");
		updateUser.setDepartmentno("2");
		updateUser.setSalary("111");
		updateUser.setPincode("112212");
		updateUser.setUserid("zUBiRdETa8r6GX7I1uw0");
		updateUser.setId("QLit4qLZyIc79MeyhdVh");
		return updateUser;
	}
	
	public UpdateUserDataPOJO getUserDataToUpdate(String department,String id) {
		updateUser = new UpdateUserDataPOJO();
		updateUser.setAccountno("TA-GV11122");
		updateUser.setDepartmentno(department);
		updateUser.setSalary("111");
		updateUser.setPincode("112212");
		updateUser.setUserid("zUBiRdETa8r6GX7I1uw0");
		updateUser.setId(id);
		return updateUser;
	}

	public DeleteUserDataPOJO getUserDataToDelete() {
		DeleteUserDataPOJO deleteUser = new DeleteUserDataPOJO();
		deleteUser.setId("QLit4qLZyIc79MeyhdVh");
		deleteUser.setUserid("zUBiRdETa8r6GX7I1uw0");
		return deleteUser;
	}
	
	public DeleteUserDataPOJO getUserDataToDelete(String id) {
		DeleteUserDataPOJO deleteUser = new DeleteUserDataPOJO();
		deleteUser.setId(id);
		deleteUser.setUserid("zUBiRdETa8r6GX7I1uw0");
		return deleteUser;
	}
}
