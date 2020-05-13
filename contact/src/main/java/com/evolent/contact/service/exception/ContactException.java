package com.evolent.contact.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus statusCode;
	private String thrownByMethod;
	private String[] thrownByMethodArgs;

	public ContactException(Throwable cause) {
		super(cause);
	}

	public ContactException(String statusMessage) {
		super(statusMessage);
	}

	public ContactException(String statusMessage, Exception exception) {
		super(statusMessage, exception);
	}

	public ContactException(HttpStatus httpStatus, String statusMessage) {
		super(statusMessage);
		this.statusCode = statusCode;
	}

	public ContactException(HttpStatus httpStatus, String statusMessage, Exception exception) {
		super(statusMessage, exception);
		this.statusCode = statusCode;
	}

	public ContactException(HttpStatus statusCode, String statusMessage, String thrownByMethod,
			String[] thrownByMethodArgs) {
		super(statusMessage);
		this.statusCode = statusCode;
		this.thrownByMethod = thrownByMethod;
		this.thrownByMethodArgs = thrownByMethodArgs;
	}

	public ContactException(HttpStatus statusCode, String statusMessage, String thrownByMethod,
			String[] thrownByMethodArgs, Exception exception) {
		super(statusMessage, exception);
		this.statusCode = statusCode;
		this.thrownByMethod = thrownByMethod;
		this.thrownByMethodArgs = thrownByMethodArgs;
	}
}
