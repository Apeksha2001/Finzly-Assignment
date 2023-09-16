package com.finzly.fxtrading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CurrencyPairNotFoundException.class)
	public ResponseEntity<String> handleCurrencyPairNotFoundException(CurrencyPairNotFoundException ex) {
		String errorMessage = "Currency pair is not available.";
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}

	@ExceptionHandler(CurrencyPairAlreadyExist.class)
	public ResponseEntity<String> handleCurrencyPairAlreadyExist(CurrencyPairAlreadyExist ex) {
		String errorMessage = "Currency Pair Is Already In Database.";
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}

	@ExceptionHandler(AmountShouldBeGreaterThanZeroException.class)
	public ResponseEntity<String> handleAmountShouldBeGreaterThanZeroException(
			AmountShouldBeGreaterThanZeroException ex) {
		String errorMessage = "Amount is not valid.";
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
}
