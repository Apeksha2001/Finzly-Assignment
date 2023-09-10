package com.finzly.foreignExchangeApp.utility;

import com.finzly.foreignExchangeApp.StaticMember.USDINRRate;
import com.finzly.foreignExchangeApp.model.Trade;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for validating and processing trade-related data.
 */

public class ValidateObject {

    public static Map<String, String> validateTrade(Trade trade) {
        Map<String, String> map = new HashMap<>();
        try {
            if (trade == null) {
                // Handle the case where 'trade' is null
                return Collections.singletonMap("error", "Trade is null");
            }
            if (trade.getAmount() <= 0) {
                map.put("Amount", "Amount should be grater than 0");
            } else {
                double convertedAmount = trade.getAmount() * USDINRRate.getUsdToInrRate();
                String formattedAmount = String.format("INR %.2f", convertedAmount);
                trade.setConvertedINRAmount(formattedAmount);
            }
            if (trade.getCustomerName() == null || trade.getCustomerName().isEmpty()) {
                map.put("Name", "Name should be not blank");
            }
            if (!trade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
                map.put("CurrencyPair", "Kindly enter valid currency pair (USDINR) ");
            }

        } catch (Exception e) {
            return Collections.singletonMap("error", "Kindly check request body");

        }

        return map;

    }
}
