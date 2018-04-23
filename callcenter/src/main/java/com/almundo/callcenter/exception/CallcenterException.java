package com.almundo.callcenter.exception;

/**
 * The Class CallcenterException.
 */
public class CallcenterException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9072029775608273229L;

	/**
	 * Instantiates a new callcenter exception.
	 */
	public CallcenterException() {
		super();
	}

	/**
	 * Instantiates a new callcenter exception.
	 *
	 * @param message the message
	 */
	public CallcenterException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new callcenter exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public CallcenterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new callcenter exception.
	 *
	 * @param cause the cause
	 */
	public CallcenterException(Throwable cause) {
		super(cause);
	}
}