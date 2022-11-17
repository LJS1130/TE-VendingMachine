package com.techelevator.view;

import com.techelevator.VendingMachineCLI;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

    private PrintWriter out;
    private Scanner in;

    public Menu(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.parseInt(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
            if (choice == null) {
                out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
            }
        } catch (NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will be null
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }
        out.print(System.lineSeparator() + "Please choose an option >>> ");
        out.flush();
    }

    public String getSlotIdFromUserInput() {
        do {
            System.out.println("Please enter Slot ID");
            Scanner userInput = new Scanner(System.in);
            String selection = userInput.nextLine();
            if (selection.equals("A1") || selection.equals("A2") || selection.equals("A3") || selection.equals("A4") || selection.equals("B1") || selection.equals("B2") || selection.equals("B3") || selection.equals("B4") || selection.equals("C1") || selection.equals("C2") || selection.equals("C3") || selection.equals("C4") || selection.equals("D1") || selection.equals("D2") || selection.equals("D3") || selection.equals("D4")) {
                return selection;

            } else {
                System.out.println(System.lineSeparator() + "*** " + selection + " is not a valid option ***" + System.lineSeparator());
            }
        } while (true);
    }
}