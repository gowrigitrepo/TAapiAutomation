package com.test.constants;

import com.test.utils.Utils;

public class SourcePath {
	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String DATA_PROPERTIES_PATH = USER_DIR + "/src/test/resources/data.properties";
	public static final String URI = Utils.getDataProperty("uri");
	public static final String USER_NAME = Utils.getDataProperty("username");
	public static final String PASSWORD = Utils.getDataProperty("password");
	public static final String JSON_PATH_FIRST_TOKEN = Utils.getDataProperty("firsttoken");
	public static final String USER_LOGIN_JSON = Utils.getDataProperty("userlogin");
	public static final String CREATE_USER_DATA_JSON = Utils.getDataProperty("createuserdata");
	public static final String UPDATE_USER_DATA_JSON = Utils.getDataProperty("updateuserdata");
	public static final String DELETE_USER_DATA_JSON = Utils.getDataProperty("deleteuserdata");
	public static final int STATUS_CODE_200 = 200;
	public static final int STATUS_CODE_201 = 201;
	public static final int STATUS_CODE_401 = 401;
	
}
