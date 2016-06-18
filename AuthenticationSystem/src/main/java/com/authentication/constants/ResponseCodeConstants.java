package com.authentication.constants;

public interface ResponseCodeConstants {

	public static enum ResponseCodeType {
		RETRY, SYSTEM_ERROR, LOGIC_ERROR, DATA_ERROR, SUCCESS
	}

	String success = "0";
	String userNotFound = "ACC_NF";
	String passNotMatched = "INV_PASS";
}
