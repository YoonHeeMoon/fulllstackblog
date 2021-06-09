package com.yoom.blog;

import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	private ErrorCode message;

	public RestException(HttpStatus status, ErrorCode message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message.toString();
	}
}