package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    private static final String FEED_MONEY_MENU_OPTION_$1 = "$1.00";
    private static final String FEED_MONEY_MENU_OPTION_$2 = "$2.00";
    private static final String FEED_MONEY_MENU_OPTION_$5 = "$5.00";
    private static final String FEED_MONEY_MENU_OPTION_$10 = "$10.00";
    private static final String FEED_MONEY_MENU_OPTION_$20 = "$20.00";
    private static final String FEED_MONEY_MENU_OPTION_$50 = "$50.00";
    private static final String[] FEED_MONEY_MENU_OPTIONS = {FEED_MONEY_MENU_OPTION_$1, FEED_MONEY_MENU_OPTION_$2, FEED_MONEY_MENU_OPTION_$5, FEED_MONEY_MENU_OPTION_$10, FEED_MONEY_MENU_OPTION_$20, FEED_MONEY_MENU_OPTION_$50, PURCHASE_MENU_OPTION_SELECT_PRODUCT};

    private Menu menu;
    private VendingMachine vendingMachine;
    private String selection;

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(System.in, System.out);
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineCLI cli = new VendingMachineCLI(menu, vendingMachine);
        cli.run();
    }


    public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
        this.menu = menu;
        this.vendingMachine = vendingMachine;
    }

    public void run() {

        String choice;
        while (true) {
            choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                System.out.println(vendingMachine.getInventory().getProductList());

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                String purchaseMenuChoice;
                do {
                    printCurrentMoneyProvided();
                    purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

                        String feedMoneyChoice;
                        do {
                            feedMoneyChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
                            if (feedMoneyChoice.equals(FEED_MONEY_MENU_OPTION_$1)) {
                                vendingMachine.feedMoney(feedMoneyChoice);
                                printCurrentMoneyProvided();
                            } else if (feedMoneyChoice.equals(FEED_MONEY_MENU_OPTION_$2)) {
                                vendingMachine.feedMoney(feedMoneyChoice);
                                printCurrentMoneyProvided();
                            } else if (feedMoneyChoice.equals(FEED_MONEY_MENU_OPTION_$5)) {
                                vendingMachine.feedMoney(feedMoneyChoice);
                                printCurrentMoneyProvided();
                            } else if (feedMoneyChoice.equals(FEED_MONEY_MENU_OPTION_$10)) {
                                vendingMachine.feedMoney(feedMoneyChoice);
                                printCurrentMoneyProvided();
                            } else if (feedMoneyChoice.equals(FEED_MONEY_MENU_OPTION_$20)) {
                                vendingMachine.feedMoney(feedMoneyChoice);
                                printCurrentMoneyProvided();
                            } else if (feedMoneyChoice.equals(FEED_MONEY_MENU_OPTION_$50)) {
                                vendingMachine.feedMoney(feedMoneyChoice);
                                printCurrentMoneyProvided();
                            }
                        } while (!feedMoneyChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT));

                    } else if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                        selection = menu.getSlotIdFromUserInput();
                        vendingMachine.dispense(selection);
                        System.out.println(selection + " " + vendingMachine.bleh + " " + vendingMachine.price + " " + vendingMachine.sound);
                        /*  choice = Arrays.toString(PURCHASE_MENU_OPTIONS);*/
                    } else if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                        List<BigDecimal> change = vendingMachine.getChange();
                        System.out.println(change.toString().replace("[", "Quarter(s): ").replace("]", "").replaceFirst(", ", "\nDime(s): ").replaceFirst(", ", "\nNickel(s): ").replace("E+1", ""));

                    }
                } while (!purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION));
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(1);
            }

        }

    }

    private void printCurrentMoneyProvided() {
        System.out.println("_________________________________");
        System.out.println("Current Money Provided: $" + vendingMachine.getCurrentMoneyProvided());
        System.out.println("---------------------------------");
        /*System.out.println("Select another face value, or continue to Select a Product");*/
    }
}


