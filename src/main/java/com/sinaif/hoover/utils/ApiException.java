package com.sinaif.hoover.utils;
/**
 *
 */

public class ApiException extends RuntimeException{
	
	private static final long serialVersionUID = -855029911285953787L;
	private int error;
	private String message;
	
	public ApiException(int error,String errorx){
		this.error = error;
		this.message = errorx;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
