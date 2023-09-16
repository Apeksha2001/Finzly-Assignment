package com.finzly.fxtrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.dao.CurrencyPairDao;
import com.finzly.fxtrading.dao.TradeDao;
import com.finzly.fxtrading.entity.CurrencyPair;
import com.finzly.fxtrading.entity.Trade;
import com.finzly.fxtrading.exception.AmountShouldBeGreaterThanZeroException;
import com.finzly.fxtrading.exception.CurrencyPairNotFoundException;
import com.finzly.fxtrading.utility.ValidationUtils;

/**
 * Service class for managing Trade related entities.
 */
@Service
public class TradeService {

	@Autowired
	TradeDao tradeDao;

	@Autowired
	CurrencyPairDao currencyPairDao;

	public List<Trade> getAllTrade(Trade trade) {
		return tradeDao.getAllTrade(trade);
	}

	public String addTrade(Trade trade) {

		// Get all currency pairs from the database
		List<CurrencyPair> currencyPairs = currencyPairDao.getAllCurrencyPair();

		// Find the currency pair that matches the one provided in the trade
		CurrencyPair currencyPair = null;
		for (CurrencyPair pair : currencyPairs) {
			if (pair.getCurrencyPair().equalsIgnoreCase(trade.getCurrencyPair())) {
				currencyPair = pair;
				break;
			}
		}

		if (currencyPair == null) {
			throw new CurrencyPairNotFoundException("Currency pair not found: " + currencyPair);
		}

		String customerNameValidationResult = ValidationUtils.validateCustomerName(trade.getCustomerName());
		if (customerNameValidationResult != null) {
			return customerNameValidationResult; // Return the validation message
		}

		if (trade.getAmount() <= 0) {
			throw new AmountShouldBeGreaterThanZeroException("Amount is not valid");
		}

		double exchangeRate = currencyPair.getExchangeRate();
		double amount = trade.getAmount();
		double convertedAmount = amount * exchangeRate;

		// Set the rate and converted amount in the trade object
		trade.setRate(exchangeRate);
		trade.setConvertedAmount(convertedAmount);

		return tradeDao.addTrade(trade);
	}
}
