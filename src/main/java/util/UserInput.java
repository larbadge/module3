package util;

import console.Actions;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class UserInput {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static int getChoice() {
        int choice;
        int maxChoice = Actions.values().length - 1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(getString());
                if (choice < 0 || choice > maxChoice) {
                    System.out.println("Invalid choice.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a whole number.");
            }
        } while (true);

        return choice;
    }

    public static double getDouble() {
        double num;
        do {
            try {
                num = Double.parseDouble(getString());
                if (num < 0 || num >= 100) {
                    System.out.println("Invalid choice.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        } while (true);

        return num;
    }

    public static String getString() {
        String str = "";
        try {
            str = READER.readLine();
        } catch (IOException e) {
            log.error("Error reading input from console.", e);
        }
        return str;
    }


}
