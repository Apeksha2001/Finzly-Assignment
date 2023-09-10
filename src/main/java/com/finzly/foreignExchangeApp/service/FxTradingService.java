package com.finzly.foreignExchangeApp.service;

import com.finzly.foreignExchangeApp.model.Trade;

import java.util.List;

public interface FxTradingService {

    public Object bookTrade(Trade trade);

    public List<Trade> printTrades();

}
