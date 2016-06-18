package com.authentication.exceptions;

public abstract class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1577189077443798408L;

	protected BaseException() {
	}

	protected BaseException(String message) {
		super(message);
	}

	public abstract boolean isExceptionCode(BaseExceptionCode code);
}
