package FXTradingApp;

public class USDINRTrade extends CurrencyTrade{
    //It's applicable for USDINR only
    private static double usdToInrRate = USDINRRate.getUsdToInrRate();

    public USDINRTrade(String currencyPair, String customerName, double amount, double rate) {
        super(currencyPair, customerName, amount, rate);
    }
}
