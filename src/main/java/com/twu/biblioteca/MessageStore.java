package com.twu.biblioteca;

public final class MessageStore {

    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String getMenu() {
        return "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n";
    }

    public static String getQuitMessage() {
        return "Quiting Application...";
    }

    public static String getCheckoutPrompt() {
        return "Enter the name of the book to be checked out:";
    }

    public static String getInvalidInputMessage() {
        return "Please select a valid option!\n";
    }

    public static String getSuccessfulCheckoutMessage() {
        return "Thank you! Enjoy the book\n";
    }
}
