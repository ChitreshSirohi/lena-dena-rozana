package com.cs.myapps.lenaDenaRozana.util;

public class Constants {
	
	private static final String OWNER_ID="ownerId";
	private static final String HOME_PAGE = "/lena-dena-rozana/";
	private static final String LOGIN_PAGE = "/lena-dena-rozana/login";
	private static final String REGISTER_PAGE = "/lena-dena-rozana/owner";
	private static final String SAVE_OWNER = "/lena-dena-rozana/saveOwner";
	private static final String VERIFY_OWNER = "/lena-dena-rozana/verifyOwner";
	private static final String LOGOUT = "/lena-dena-rozana/logout";
	private static final String DB_SUFFIX = "TransDb";
	
	public static String getVerifyOwner() {
		return VERIFY_OWNER;
	}
	public static String getOwnerId() {
		return OWNER_ID;
	}
	public static String getHomePage() {
		return HOME_PAGE;
	}

	public static String getLoginPage() {
		return LOGIN_PAGE;
	}
	public static String getRegisterPage() {
		return REGISTER_PAGE;
	}
	public static String getSaveOwner() {
		return SAVE_OWNER;
	}
	public static String getLogout() {
		return LOGOUT;
	}
	public static String getDbSuffix() {
		return DB_SUFFIX;
	}

}
