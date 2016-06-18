package com.authentication.utils;

import com.authentication.constants.ResponseCodeConstants;
import com.authentication.constants.ResponseCodeConstants.ResponseCodeType;
import com.authentication.dto.BaseResponseDTO;

public class CommonUtils {

	public static String generateResponseCode(String code, ResponseCodeType responseType) {
		switch (responseType) {
		case SUCCESS:
			return code;
		case DATA_ERROR:
			return "2." + code;
		case LOGIC_ERROR:
			return "3." + code;
		case RETRY:
			return "1." + code;
		case SYSTEM_ERROR:
			return "4." + code;
		}
		return null;
	}

	public static String generateSuccessResponseCode() {
		return generateResponseCode(ResponseCodeConstants.success, ResponseCodeType.SUCCESS);
	}

	public static void generateResponse(BaseResponseDTO baseResponse, String code, ResponseCodeType responseType) {
		baseResponse.setCode(generateResponseCode(code, responseType));
	}

	public static void generateSuccessfulResponse(BaseResponseDTO baseResponse) {
		baseResponse.setCode(generateSuccessResponseCode());
	}
}
