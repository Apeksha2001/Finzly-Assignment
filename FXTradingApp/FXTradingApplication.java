package FXTradingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FXTradingApplication extends FXTrade {
    private static final double usdToInrRate = USDINRRate.getUsdToInrRate();
    private static final List<USDINRTrade> trades = new ArrayList<>();  //used to store instance of trade class


    @Override
    protected void bookTrade(Scanner scanner) {
        System.out.println("Enter customer Name:");  //Customer name must be valid string
        String customerName = scanner.nextLine();
        if (!Validation.isValidCustomerName(customerName)) {
            System.out.println("Please enter a valid customer name without special characters or numbers.");
            return;
        }


        System.out.println("Enter Currency Pair:");
        String currencyPair = scanner.nextLine();
        if (!Validation.isValidCurrencyPair(currencyPair)) {
            System.out.println("Invalid Currency : Kindly use USDINR");
            return;
        }

        System.out.println("Enter amount to transfer:"); //Entered amount must be positive integer

        double amount=0;
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = scanner.nextLine();
                amount = Double.parseDouble(input);

                if (amount <= 0) {
                    System.out.println("Kindly Enter valid  amount!!!");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Kindly Enter valid  amount!!!");
            }
        }


        System.out.println("Do you want to get Rate? (Yes/No)");   //Enter mention option

        String rateChoice = scanner.nextLine();

        if(Validation.isValidRateChoice(rateChoice))
        {
            if (rateChoice.equalsIgnoreCase("Yes")) {
                System.out.println();
                System.out.println("You are transferring INR " + amount * usdToInrRate +
                        " to " + customerName + ". (Assuming that rate was " + usdToInrRate + ")");
                System.out.println();
            }

        }else {
            System.out.println("Kindly Enter Correct Option");
            return;
        }

        System.out.println("Book/Cancel this trade? (Book/Cancel)");
        String bookChoice = scanner.nextLine();

        if (bookChoice.equalsIgnoreCase("Book")) {
            trades.add(new USDINRTrade(currencyPair, customerName, amount, usdToInrRate));
            System.out.println("Trade for USDINR has been booked with rate " + usdToInrRate +
                    ". The amount of Rs " + (amount * usdToInrRate) + " will be transferred in 2 working days to " + customerName + ".");
            System.out.println();
        } else if (bookChoice.equalsIgnoreCase("Cancel")) {
            System.out.println("Trade is Canceled.");
            System.out.println();
        }


    }

    @Override
    protected void printTrades() {
        System.out.printf(" %-8s  %-12s  %-15s  %-12s  %-6s %n",
                "TradeNo", "CurrencyPair", "CustomerName", "Amount", "Rate");      //is used for print formatted string
        for (CurrencyTrade trade : trades) {
            String formattedAmount = String.format("INR%.2f", trade.getAmount() * trade.getRate());
            System.out.printf(" %-8s  %-12s  %-15s  %-12s %-6s %n",
                    trade.getTradeNo(),
                    trade.getCurrencyPair(),
                    trade.getCustomerName(),
                    formattedAmount,
                    trade.getRate());
        }

    }


    @Override
    protected boolean exitConfirmation(Scanner scanner) {
        System.out.println("Do you really want to exit (Y/N)");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("Y");
    }

}

