package com.finzly.foreignExchangeApp.controller;

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
    private int tradeCounter=1;

    @PostMapping("/bookTrade")
    public Object bookTrade(@RequestBody Trade trade) {


            Object obj = service.bookTrade(trade);
            if (obj instanceof Boolean) {
                if ((boolean) obj == true) {
                    trade.setTradeNo(tradeCounter++);
                    return ResponseEntity.ok("Trade Booked Successfully");
                }

            }
            return obj;
        }


    @GetMapping("/getAllTrade")
    public Object getAllTrade() {
        List<Trade> list = service.printTrades();

        if (list.isEmpty()) {
            return ResponseEntity.ok("Trade Not Found");
        } else {
            return list;
        }
    }

}
