package FXTradingApp;

public abstract class CurrencyTrade {
    //Abstract class...If we want to add new currency then it's feasible to add
    private static int tradeCounter = 1;   //whenever new trade is generated unique id gets assigned

    private int tradeNo;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double rate;

    public CurrencyTrade(String currencyPair, String customerName, double amount, double rate) {
        this.tradeNo = tradeCounter++;
        this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.amount = amount;
        this.rate = rate;
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

    public double getRate() {
        return rate;
    }
}


