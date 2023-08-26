package FXTradingApp;

public class USDINRRate {

    // The rate for USDINR can be hardcoded in program but should be easy to change.
    private static double usdToInrRate = 66.00;

    public static double getUsdToInrRate() {
        return usdToInrRate;
    }

    public static void setUsdToInrRate(double rate) {
        usdToInrRate = rate;
    }


}
