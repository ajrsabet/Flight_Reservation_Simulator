package util;

import java.util.Scanner;

public class InputTest {
    private Scanner scanner = new Scanner(System.in);

    // Test String input
    public String String() {
        String input;
        while (true) {
            try {
                input = scanner.nextLine();
                if (input.length() > 0) {
                    break; // Exit the loop if input is valid
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    // Test int input
    public int Int() {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    // Test char input
    public char Char() {
        char input;
        while (true) {
            try {
                input = scanner.next().charAt(0);
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a character.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }
}