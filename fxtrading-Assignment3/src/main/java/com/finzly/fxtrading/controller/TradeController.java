package com.finzly.fxtrading.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtrading.service.TradeService;
import com.finzly.fxtrading.entity.Trade;

/**
 * Controller class for managing user-related operations like add trade or get trade.
 */

@RestController
@RequestMapping("/trade")
public class TradeController {

	@Autowired
	TradeService tradeService;

	/**
	 * Get a list of all trade.
	 *
	 * @return A list of all trades.
	 * @author Apeksha
	 */
	@GetMapping("/getalltrade")
	public List<Trade> getAllTrade(Trade trade) {
		return tradeService.getAllTrade(trade);

	}

	/**
	 * This API is used to add trade details
	 *
	 * @author Apeksha
	 */
	@PostMapping("/addtrade")
	public String addTrade(@RequestBody Trade trade) {
		return tradeService.addTrade(trade);
	}
}
