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
    static int[] arr = null; // reference to the array
    static boolean isArrayCreated = false; // variable to track if array exists
    static int currentSize = 0; // tracks how many elements are actually stored


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
                    createArray();
                    break;
                case 2:
                    insertElements();
                    break;
                case 3:
                    if (!isArrayCreated) {
                        System.out.println("Error: You must create an array first.\n");
                        break;
                    }
                    break;
                case 4:
                    displayArray();
                    break;
                case 5:
                    if (!isArrayCreated) {
                        System.out.println("Error: You must create an array first.\n");
                        break;
                    }
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select from 1, 2, 3, 4, 5 or 0 only.\n");
            }
        }
    }

    // Input Validation Method
    public static Integer getValidatedInput() {
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input cannot be empty. Please enter a valid number.\n");
            return null; // invalid input = back to menu
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.\n");
            return null; // invalid input = back to menu
        }
    }

    // Create Array Method
    public static void createArray() {
        if (isArrayCreated) {
            System.out.println("Error: An array of " + arr.length + " has already been created.\n");
            return;
        }

        while (true) {
        System.out.print("Enter the size of the array (5 - 20): ");
        Integer size = getValidatedInput();

        if (size == null) {
            // invalid input = stay in loop and re-ask
            continue;
        } else if (size < 5 || size > 20) {
            System.out.println("Error: Array size must be between 5 and 20.\n");
            continue; // keep looping until valid
        }

        arr = new int[size];
        isArrayCreated = true;
        System.out.println("Array of size " + size + " has been created successfully!\n");
        break; // exit the loop once array is created
        }
    }

    // Insert Elements Method
    public static void insertElements() {
        if (!isArrayCreated) {
            System.out.println("Error: You must create an array first.\n");
            return;
        }

        if (currentSize == arr.length) {
            System.out.println("Error: The array is already full. You cannot insert more elements.\n");
            return;
        }
        
        while (true) {
            System.out.print("Enter integer values to insert (enter -99 to stop): ");
            Integer value = getValidatedInput();

            if (value == null) {
                continue;
            }

            if (value == -99) {
                System.out.println("Insert operation terminated. Returning to main menu.\n");
                break;
            }

            if (contains(value)) {
                System.out.println("Error: Duplicate value " + value + " not allowed.\n");
                continue;
            }

            if (currentSize < arr.length) {
                arr[currentSize] = value; // insert at the next available slot
                System.out.println("Inserted " + value + " at position " + currentSize + ".");
                currentSize++;
            } else {
                System.out.println("Error: The array is already full. You cannot insert more elements.\n");
                break;
            }

            if (currentSize == arr.length) {
                System.out.println("The array is now full. No more insertions possible.\n");
                break;
            }
        }
    }

    // Helper Method: check if value already exists
    private static boolean contains(int value) {
        for (int i = 0; i < currentSize; i++) {
            if (arr[i] == value) return true;
        }
        return false;
    }

    // Display Array Method (Not yet fully fixed - just for testing)
    public static void displayArray() {
    if (!isArrayCreated) {
        System.out.println("Error: You must create an array first.\n");
        return;
    }

    if (currentSize == 0) {
        System.out.println("The array is empty. No elements to display.\n");
        return;
    }

    System.out.print("Array elements: ");
    for (int i = 0; i < currentSize; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println("\n");
    }


}