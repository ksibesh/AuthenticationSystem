package com.authentication.exceptions;

public class AuthenticationException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1788157304688495920L;

	public static enum AuthenticationExceptionCode implements BaseExceptionCode {
		ACC_NOT_FOUND, INVALID_PASS
	}

	private AuthenticationExceptionCode code;

	public AuthenticationException(AuthenticationExceptionCode code) {
		this.code = code;
	}

	public AuthenticationException(AuthenticationExceptionCode code, String message) {
		super(message);
		this.code = code;
	}

	@Override
	public boolean isExceptionCode(BaseExceptionCode code) {
		if (code instanceof AuthenticationExceptionCode && this.code.equals(code)) {
			return true;
		}
		return false;
	}

}
