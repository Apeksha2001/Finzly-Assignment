package FXTradingApp;

public class Validation {

    //Validation of Customer Name

    public static boolean isValidCustomerName(String customerName) {
        String regex =  "^[a-zA-Z.\\s]+$";
        return customerName.matches(regex);
    }


    //Validation for currency pair
    public static boolean isValidCurrencyPair(String currencyPair){
        if (!currencyPair.equalsIgnoreCase("USDINR")) {
            return false;
        }
        return true;
    }

    //Validation for rate choice
    public static boolean isValidRateChoice(String rateChoice){

        if(!rateChoice.equalsIgnoreCase("Yes") && !rateChoice.equalsIgnoreCase("No")){
            return false;
        }
        return true;
    }



}












