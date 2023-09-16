package com.finzly.fxtrading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.service.CurrencyPairService;
import com.finzly.fxtrading.entity.CurrencyPair;

/**
 * Controller class for managing currency pair related operations
 * 
 */

@RestController
@RequestMapping("/currencypair")
public class CurrencyPairController {

	@Autowired
	CurrencyPairService currencyPairService;

	/**
	 * Get a list of all currency pair.
	 *
	 * @return A list of all currency pair.
	 * @author Apeksha
	 */
	@GetMapping("/get-all-currencypair")
	public List<CurrencyPair> getAllCurrencyPair() {
		return currencyPairService.getAllCurrencyPair();

	}

	/**
	 * This API is for add new currency pair
	 * 
	 * @author Apeksha
	 */

	@PostMapping("/add-currencypair")
	public String addCurrencyPair(@RequestBody CurrencyPair currencyPairObj) {
		return currencyPairService.addCurrencyPair(currencyPairObj);
	}

	/**
	 * This API is for update currency pair
	 * 
	 * @author Apeksha
	 */
	@PutMapping("/update-currencypair/{ccy}")
	public String updateCurrencyPair(@PathVariable String ccy) {
		return currencyPairService.updateCurrencyPair(ccy);
	}

	/**
	 * This API is for delete currency pair
	 * 
	 * @author Apeksha
	 */
	@DeleteMapping("/delete-currencypair/{currencyPair}")
	public String delteCurrencyPair(@PathVariable String currencyPair) {
		return currencyPairService.delteCurrencyPair(currencyPair);
	}

}
