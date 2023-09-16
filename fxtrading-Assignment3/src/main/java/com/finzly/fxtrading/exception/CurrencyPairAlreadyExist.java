package com.finzly.fxtrading.exception;

/**
 * Custom exception class to indicate that a currency pair already exists. This
 * exception is typically thrown when an operation attempts to add a currency
 * pair to database, but a currency pair with the same identifier already
 * exists.
 */
public class CurrencyPairAlreadyExist extends RuntimeException {

	public CurrencyPairAlreadyExist(String message) {
		super(message);
	}

	public CurrencyPairAlreadyExist(String message, Throwable cause) {
		super(message, cause);
	}
}