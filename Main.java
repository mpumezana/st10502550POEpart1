package com.mycompany.main;

import java.util.Scanner;

public class Main {

    // Create Scanner for user input
    static Scanner input = new Scanner(System.in);

    // Store registered user details
    static String registeredUsername;
    static String registeredPassword;
    static String registeredCellphone;

    // Check if username is valid
    public static boolean checkUserName(String username) {
        // Username must contain an underscore
        // and must be exactly 5 characters long
        return username.length() == 5 && username.contains("_");
    }

    // Check if password meets complexity requirements
    public static boolean checkPasswordComplexity(String password) {
        // Password must:
        // - Be at least 8 characters long
        // - Contain an uppercase letter
        // - Contain a lowercase letter
        // - Contain a number
        // - Contain a special character

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    // Check if cellphone number is valid
    public static boolean checkCellPhoneNumber(String number) {
        // Number must start with +27
        // followed by exactly 9 digits
        return number.matches("^\\+27[0-9]{9}$");
    }

    // Register the user
    public static void registerUser() {

        System.out.print("Enter your username: ");
        String username = input.nextLine();

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        System.out.print("Enter your cellphone number (+27): ");
        String cellphone = input.nextLine();

        // Check username
        if (!checkUserName(username)) {
            System.out.println(
                    "Username is incorrectly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length."
            );
            return;
        }

        // Check password
        if (!checkPasswordComplexity(password)) {
            System.out.println(
                    "Password is incorrectly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character."
            );
            return;
        }

        // Check cellphone
        if (!checkCellPhoneNumber(cellphone)) {
            System.out.println(
                    "Cell phone number is incorrectly formatted or does not contain an international code."
            );
            return;
        }

        // Store registered details
        registeredUsername = username;
        registeredPassword = password;
        registeredCellphone = cellphone;

        System.out.println("User registered successfully.");
    }

    // Login the user
    public static boolean loginUser(String username, String password) {

        return username.equals(registeredUsername)
                && password.equals(registeredPassword);
    }

    // Return login status message
    public static String returnLoginStatus(boolean loginSuccessfully) {

        if (loginSuccessfully) {
            return "Welcome, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main method
    public static void main(String[] args) {

        // Register the user
        registerUser();

        // Login
        System.out.println("\n--- Login ---");

        System.out.print("Enter username to login: ");
        String loginUsernameInput = input.nextLine();

        System.out.print("Enter password to login: ");
        String loginPasswordInput = input.nextLine();

        // Check login
        boolean loginSuccessful =
                loginUser(loginUsernameInput, loginPasswordInput);

        // Display login status
        System.out.println(returnLoginStatus(loginSuccessful));
    }
}

