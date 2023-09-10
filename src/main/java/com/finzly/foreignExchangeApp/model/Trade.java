package com.finzly.foreignExchangeApp.model;

import org.springframework.stereotype.Component;

@Component
public class Trade {

    private int tradeNo;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double rate;
    private String convertedINRAmount;

    public Trade() {
    }

    // Constructor for creating a new trade

    public Trade(int tradeNo, String currencyPair, String customerName, double amount, double rate, String convertedINRAmount) {
        this.tradeNo = tradeNo;
        this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.amount = amount;
        this.rate = rate;
        this.convertedINRAmount = convertedINRAmount;
    }

    // Getter methods for retrieving field values

    public int getTradeNo() {
        return tradeNo;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }


    public double getRate() {
        return rate;
    }

    public String getConvertedINRAmount() {
        return convertedINRAmount;
    }

    // Setter method for updating field
    public void setTradeNo(int tradeNo) {
        this.tradeNo = tradeNo;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setConvertedINRAmount(String convertedINRAmount) {
        this.convertedINRAmount = convertedINRAmount;
    }
}


