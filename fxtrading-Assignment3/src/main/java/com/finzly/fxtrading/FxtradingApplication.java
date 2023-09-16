package com.finzly.fxtrading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Spring Boot demo project.
 */
@SpringBootApplication
public class FxtradingApplication {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(FxtradingApplication.class);

		SpringApplication.run(FxtradingApplication.class, args);

		logger.info("FX Trading Application Started");

	}

}
