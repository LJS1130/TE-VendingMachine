
package com.techelevator.view;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private static final File sourceFile = new File("vendingmachine.csv");
    private List<Product> inventory;

    public List<Product> getInventory() {
        return inventory;
    }

    public Inventory() {
        setInventory();
    }

    private void setInventory() {
        inventory = new ArrayList<>();
        try (Scanner copyScanner = new Scanner(sourceFile)) {
            while (copyScanner.hasNextLine()) {
                String itemLine = copyScanner.nextLine();
                String[] itemFacts = itemLine.split("\\|");
                BigDecimal price = new BigDecimal(itemFacts[2]);

                if (itemFacts[3].equals("Chip")) {
                    Product chip = new Chip();
                    inventory.add(new Chip(itemFacts[0], itemFacts[1], price, itemFacts[3]));
                }
                if (itemFacts[3].equals("Drink")) {
                    Product drink = new Drink();
                    inventory.add(new Drink(itemFacts[0], itemFacts[1], price, itemFacts[3]));
                }
                if (itemFacts[3].equals("Candy")) {
                    Product candy = new Candy();
                    inventory.add(new Candy(itemFacts[0], itemFacts[1], price, itemFacts[3]));
                }
                if (itemFacts[3].equals("Gum")) {
                    Product gum = new Gum();
                    inventory.add(new Gum(itemFacts[0], itemFacts[1], price, itemFacts[3]));
                }
            }

            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }

        public String getProductList () {
            String inventoryString = "";
            for (Product n : inventory) {
                String productString = n.toString();
                inventoryString += "\r\n" + productString;
            }
            return inventoryString;
        }
    }



