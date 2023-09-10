package com.finzly.foreignExchangeApp.service.impl;

import com.finzly.foreignExchangeApp.model.Trade;
import com.finzly.foreignExchangeApp.service.FxTradingService;
import com.finzly.foreignExchangeApp.utility.ValidateObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FxTradingServiceImpl implements FxTradingService {

    List<Trade> list = new ArrayList<>();

    @Override
    public Object bookTrade(Trade trade) {


        Map<String, String> map = ValidateObject.validateTrade(trade);
        if (map == null || map.isEmpty()) {
            list.add(trade);
            return true;
        } else {
            return map;
        }

    }

    @Override
    public List<Trade> printTrades() {
        return list;
    }
}
