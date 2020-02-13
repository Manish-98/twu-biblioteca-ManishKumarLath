package com.twu.biblioteca;

public final class MessageStore {

    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static String getMenu() {
        return "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n" +
                "5. List of available movies\n" +
                "6. Checkout movie\n";
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

    public static String getUnsuccessfulCheckoutMessage() {
        return "Sorry, that book is not available\n";
    }

    public static String getReturnBookPrompt() {
        return "Enter the name of the book to be returned:";
    }

    public static String getSuccessfulReturnMessage() { return "Thank you for returning the book\n"; }

    public static String getUnSuccessfulReturnMessage() { return "That is not a valid book to return\n"; }

    public static String getCheckoutMoviePrompt() {
        return "Enter the name of the movie to be checked out:";
    }

    public static String getLoginRequest() {
        return "Please Log into your profile to access this feature...\n";
    }
}
