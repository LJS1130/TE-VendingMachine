package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine extends RuntimeException {

    Drink drink = new Drink();
    Gum gum = new Gum();
    Chip chip = new Chip();
    Candy candy = new Candy();

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
    PrintWriter logFile = new PrintWriter(new FileWriter("log.txt", true));
    public Inventory inventory = new Inventory(); //TODO PRIVATE
    public static BigDecimal currentMoneyProvided = new BigDecimal(0.00);
    private static final BigDecimal QUARTER = new BigDecimal(0.25);
    private static final BigDecimal DIME = new BigDecimal(0.10);
    private static final BigDecimal NICKEL = new BigDecimal(0.05);
    private static final BigDecimal[] COINS = {QUARTER, DIME.round(new MathContext(3)), NICKEL.round(new MathContext(3))};


    public VendingMachine() throws IOException {
    }

    public Inventory getInventory() {
        return inventory;
    }

    public static BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public PrintWriter logger(String temp, BigDecimal amount) {
        logFile.format("%s %s%s $%s %n", dateFormatter.format(LocalDateTime.now()), temp, amount.toString(), currentMoneyProvided.toString());
        logFile.flush();
        return logFile;
    }


    public BigDecimal feedMoney(String choice) {
        choice = choice.substring(1, choice.length());
        BigDecimal feed = new BigDecimal(choice);
        currentMoneyProvided = currentMoneyProvided.add(feed);
        logger("FEED MONEY: $", feed);
        return currentMoneyProvided;
    }


//TODO .divide.intvalue

    public List<BigDecimal> getChange() {
        List<BigDecimal> change = new ArrayList<>();
        BigDecimal quotient;
        BigDecimal changeToGive = currentMoneyProvided;
        for (BigDecimal coin : COINS) {
            /*rem = currentMoneyProvided.remainder(coin);*/
            quotient = currentMoneyProvided.divideToIntegralValue(coin);
            change.add(quotient);
            currentMoneyProvided = currentMoneyProvided.subtract(quotient.multiply(coin));
        }
        logger("GIVE CHANGE: $", changeToGive);
        return change;
    }

    public String bleh = "";
    public String price = "";
    public String sound = "";
    public String nameAndSlot = "";

    public void dispense(String selection) {
        int i = 0;
        boolean dummy = true;
        while (dummy) {
            String slot = inventory.getInventory().get(i).getSlotId();
            if (slot.equals(selection)) {
                Product currentItem = inventory.getInventory().get(i);
                if (currentMoneyProvided.compareTo(currentItem.getPrice()) >= 0) {
                    if (currentItem.getQuantity() > 0) {
                        currentMoneyProvided = currentMoneyProvided.subtract(currentItem.getPrice());
                        currentItem.setQuantity(currentItem.getQuantity() - 1);
                        bleh = currentItem.getName();
                        price = currentItem.getPrice().toString();
                        sound = currentItem.getSound();
                        nameAndSlot = bleh + " " + slot + " $";

                        logger(nameAndSlot, currentItem.getPrice());
                        System.out.println(sound);
                        dummy = false;
                        //TODO look at sound double printing
//                        if (currentItem.getType().equals("Drink")) {
//                            System.out.println(currentItem.getSound());
//                            dummy = false;
//                        }
//                        if (currentItem.getType().equals("Gum")) {
//                            System.out.println(currentItem.getSound());
//                            dummy = false;
//                        }
//                        //return to main menu
//
//                        if (currentItem.getType().equals("Chip")) {
//                            System.out.println(currentItem.getSound());
//                            dummy = false;
//                        }
//                        //return to main menu
//
//                        if (currentItem.getType().equals("Candy")) {
//                            System.out.println(currentItem.getSound());
//                            dummy = false;
//                        }
//                        //return to main menu

                    } else {
                        System.out.println("Sorry, sold out.");
                        dummy = false;
                    }
                } else {
                    System.out.println("Need more money there bud.");
                    dummy = false;
                }
            } else {
                i++;
            }
        }
    }
}

//}
//    public log(String [VARIABLE], getprice, ){}
// appends transaction into log file
// [mm-dd-yyyy] [hh:mm:ss] [a] [VARIABLE] getprice currentMoneyProvided


//    PrintWriter
//DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss")
//FOR FINISH TRANSACTION
//   if action = feed money
//          print: date + time + "FEED MONEY: $" + vendingMachine.getFeed + " $" + vendingMachine.getCurrentMoneyProvided
//   if action = enter slot ID
//          print: date + time + vendingMachine.
//if print currentItem.getName + currentItem.getSlotId + currentItem.getPrice + getCurrentMoneyProvided
//}
//}
