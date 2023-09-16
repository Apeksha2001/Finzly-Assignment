package com.finzly.fxtrading.exception;

/**
 * Custom exception class to indicate that a currency pair was not found. This
 * exception is typically thrown when an operation or query attempts to find a
 * specific currency pair, but it does not exist in the system.
 */
public class CurrencyPairNotFoundException extends RuntimeException {

	public CurrencyPairNotFoundException(String message) {
		super(message);
	}

	public CurrencyPairNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}