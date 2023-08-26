package FXTradingApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        FXTradingApplication fxTradingApplication=new FXTradingApplication();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("...Welcome in FXTrading ...");
            System.out.println("Kindly Select an below option: (1,2,3)");
            System.out.println("1. Book Trade");
            System.out.println("2. Print Trades");
            System.out.println("3. Exit");

            if (scanner.hasNextInt()) {           //Check choice is integer or not
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    fxTradingApplication.bookTrade(scanner);
                } else if (choice == 2) {
                    fxTradingApplication.printTrades();
                } else if (choice == 3) {
                    exit = fxTradingApplication.exitConfirmation(scanner);
                } else {
                    System.out.println("Invalid option. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");

                scanner.nextLine();
            }

        }

        System.out.println("Bye - have a good day");
    }
}
