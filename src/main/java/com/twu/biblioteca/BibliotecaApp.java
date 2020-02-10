package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private List<Book> bookList;
    private Stream console;

    public BibliotecaApp(Stream console) {
        bookList = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "JK Rowling", 2000),
                new Book("Da Vinci Code", "Dan Brown", 2003),
                new Book("Brida", "Paulo Coelho", 1990)));

        this.console = console;
    }

    public void start() throws IOException {
        console.output(getWelcomeMessage());
        int option;
        label:
        while (true) {
            console.output(getMenu());
            option = Integer.parseInt(console.input());
            switch (option) {
                case 1:
                    console.output(getBookList());
                    break;
                case 2:
                    console.output(getQuitMessage());
                    break label;
                case 3:
                    console.output(getCheckoutPrompt());
                    String bookName = console.input();
                    remove(bookName);
                    break;
                default:
                    console.output(getInvalidInputMessage());
                    break;
            }
        }
    }

    private String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    private String getBookList() {
        StringBuilder listOfBooks = new StringBuilder();
        for (Book book: bookList) {
            listOfBooks.append(book);
        }

        return String.valueOf(listOfBooks);
    }

    private String getMenu() {
        return "Select an option:\n" +
                "1. List of books\n" +
                "2. Quit Application\n" +
                "3. Checkout Book\n";
    }

    private String getQuitMessage() {
        return "Quiting Application...";
    }

    private String getCheckoutPrompt() {
        return "Enter the name of the book to be checked out:";
    }

    private String getInvalidInputMessage() {
        return "Please select a valid option!\n";
    }

    private String getBookNotFoundMessage() {
        return "Book Not Found\n";
    }

    private void remove(String bookName) {
        int indexOfBook = Book.getIndexByName(bookName, bookList);
        if (indexOfBook == -1)
            console.output(getBookNotFoundMessage());
        else
            bookList.remove(indexOfBook);
    }
}
