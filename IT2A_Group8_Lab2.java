/*  ARRAY OPERATIONS MENU PROGRAM
    Group 8
    Authors: Domingo, Mario Jr. C. (Leader)
             Dela Cruz, Bic Julian (Members)
             VioVicente, Kevin Christian
    Laboratory Exercise #2
    Date: 9/7/2025

*/

import java.util.Scanner;

public class IT2A_Group8_Lab2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("           ARRAY OPERATIONS MENU         ");
            System.out.println("-----------------------------------------\n");
            System.out.println("[1] Create Array");
            System.out.println("[2] Insert Elements");
            System.out.println("[3] Search");
            System.out.println("[4] Display");
            System.out.println("[5] Delete");
            System.out.println("[0] Stop");
            System.out.print("Enter Choice: ");

            // Validate input once
            Integer validatedChoice = getValidatedInput();

            // If validation failed, go back to menu
            if (validatedChoice == null) {
                continue;
            }

            choice = validatedChoice;

            switch (choice) {
                case 1:
                    System.out.println("1. Create Array");
                    break;
                case 2:
                    System.out.println("2. Insert Element");
                    break;
                case 3:
                    System.out.println("3. Search");
                    break;
                case 4:
                    System.out.println("4. Display");
                    break;
                case 5:
                    System.out.println("5. Delete");
                    break;
                case 0:
                    System.out.println("0. Stop");
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select from 1, 2, 3, 4, 5 or 0 only.\n");
            }
        }
    }

    //Input Validation Method
    public static Integer getValidatedInput() {
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input cannot be empty. Please enter a valid number.\n");
            return null; // invalid input → back to menu
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.\n");
            return null; // invalid input → back to menu
        }
    }

    
}