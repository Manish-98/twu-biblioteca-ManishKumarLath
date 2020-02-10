package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private List<Book> bookList;

    public BibliotecaApp() {
        bookList = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "JK Rowling", 2000),
                new Book("Da Vinci Code", "Dan Brown", 2003),
                new Book("Brida", "Paulo Coelho", 1990)));
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getBookList() {
        StringBuilder listOfBooks = new StringBuilder();
        for (Book book: bookList) {
            listOfBooks.append(book);
        }

        return String.valueOf(listOfBooks);
    }

    public void showMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:\n" +
                    "1. List of books\n" +
                    "2. Quit Application\n");
            option = scanner.nextInt();
            if (option == 1) {
                System.out.println(getBookList());
            } else if (option == 2) {
                System.out.println("Quiting Application...");
                break;
            } else {
                System.out.println("Please select a valid option!");
            }
        }
        scanner.close();
    }
}
