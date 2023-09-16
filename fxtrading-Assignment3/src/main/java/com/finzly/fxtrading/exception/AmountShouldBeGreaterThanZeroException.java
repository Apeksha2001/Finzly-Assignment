package com.finzly.fxtrading.exception;

/**
 * Custom exception class to indicate that an amount should be greater than
 * zero. This exception is typically thrown when an operation or validation
 * requires the amount to be a positive value, and it is not met.
 */
public class AmountShouldBeGreaterThanZeroException extends RuntimeException {

	public AmountShouldBeGreaterThanZeroException(String message) {
		super(message);
	}

	public AmountShouldBeGreaterThanZeroException(String message, Throwable cause) {
		super(message, cause);
	}
}