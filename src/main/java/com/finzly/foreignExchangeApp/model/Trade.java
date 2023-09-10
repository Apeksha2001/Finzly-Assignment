package com.finzly.foreignExchangeApp.model;

import org.springframework.stereotype.Component;


@Component
public class Trade {

    private int tradeNo;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double USDINR_Rate =66.00;
    private String convertedINRAmount;

    public Trade() {
    }

    public Trade(int tradeNo,String currencyPair, String customerName, double amount, double USDINR_Rate,String convertedINRAmount) {
        this.tradeNo = tradeNo ;
        this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.amount = amount;
        this.USDINR_Rate = USDINR_Rate;
        this.convertedINRAmount=convertedINRAmount;
    }

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



    public double getUSDINR_Rate() {
        return USDINR_Rate;
    }

    public void setTradeNo(int tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getConvertedINRAmount() {
        return convertedINRAmount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setConvertedINRAmount(String convertedINRAmount) {
        this.convertedINRAmount = convertedINRAmount;
    }
}


