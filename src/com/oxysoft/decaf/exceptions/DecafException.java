package com.oxysoft.decaf.exceptions;

/**
 * Created by oxysoft on 20/07/14.
 */
public class DecafException extends Exception {

	public DecafException() {
		super();
	}

	public DecafException(String message) {
		super(message);
	}

	public DecafException(String message, Throwable cause) {
		super(message, cause);
	}

	public DecafException(Throwable cause) {
		super(cause);
	}

	public DecafException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
