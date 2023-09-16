package com.finzly.fxtrading.service;

import com.finzly.fxtrading.exception.CurrencyPairAlreadyExist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtrading.dao.CurrencyPairDao;
import com.finzly.fxtrading.entity.CurrencyPair;

/**
 * Service class for managing CurrencyPair entities.
 */

@Service
public class CurrencyPairService {

	@Autowired
	CurrencyPairDao currencyPairDao;

	public List<CurrencyPair> getAllCurrencyPair() {
		return currencyPairDao.getAllCurrencyPair();
	}

	public String addCurrencyPair(CurrencyPair currencyPairObj) {
		// Get all currency pairs from the database
		List<CurrencyPair> currencyPairs = currencyPairDao.getAllCurrencyPair();
		System.out.println(currencyPairs);

		// Find the currency pair that matches the one provided in the trade
		for (CurrencyPair pair : currencyPairs) {
			System.out.println(pair.getCurrencyPair());
			if (pair.getCurrencyPair().equalsIgnoreCase(currencyPairObj.getCurrencyPair())) {
				throw new CurrencyPairAlreadyExist("Currency pair already exists");

			}
		}

		return currencyPairDao.addCurrencyPair(currencyPairObj);
	}

	public String updateCurrencyPair(String ccy) {
		String[] arr = ccy.split("=");
		String currencyPair = arr[0];
		String rate = arr[1];

		double convertedRate = Double.parseDouble(rate);
		if (convertedRate <= 0) {
			return "Rate must be positive";
		}

		return currencyPairDao.updateCurrencyPair(convertedRate, currencyPair);
	}

	public String delteCurrencyPair(String currencyPair) {
		boolean deleted = currencyPairDao.delteCurrencyPair(currencyPair);
		if (deleted) {
			return "Currency Pair Deleted Suceesfully";
		}
		return "Currency Pair Not Found";
	}

}
