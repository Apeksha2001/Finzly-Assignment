package com.finzly.foreignExchangeApp.controller;

import com.finzly.foreignExchangeApp.StaticMember.USDINRRate;
import com.finzly.foreignExchangeApp.model.Trade;
import com.finzly.foreignExchangeApp.service.FxTradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/fxTrading")
public class TradeController {
    @Autowired
    private FxTradingService service;
    private int tradeCounter = 1;

    /**
     * Book a new trade.
     * <p>
     * The trade to be booked
     *
     * @return ResponseEntity containing the result of the trade booking.
     */

    @PostMapping("/bookTrade")
    public Object bookTrade(@RequestBody Trade trade) {


        Object obj = service.bookTrade(trade);
        // Check if the result is a boolean (success) or an error message
        if (obj instanceof Boolean) {
            if ((boolean) obj == true) {
                trade.setTradeNo(tradeCounter++);
                trade.setRate(USDINRRate.getUsdToInrRate());
                return ResponseEntity.ok("Trade Booked Successfully");
            }

        }
        // If not a boolean, return an error message or details
        return obj;
    }

    /**
     * Get details of a trade by its trade number.
     *
     * @return ResponseEntity containing the trade details or an error message.
     */

    @GetMapping("/getAllTrade")
    public Object getAllTrade() {
        // Retrieve trade details from the service
        List<Trade> list = service.printTrades();

        if (list.isEmpty()) {
            return ResponseEntity.ok("Trade Not Found");
        } else {
            return list;
        }
    }

}
