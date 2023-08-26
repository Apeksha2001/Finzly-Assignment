package FXTradingApp;

import java.util.Scanner;

public abstract class FXTrade {
    //If new functionality want to add
    abstract void bookTrade(Scanner scanner);
    abstract void printTrades();
    abstract boolean exitConfirmation(Scanner scanner);
}
