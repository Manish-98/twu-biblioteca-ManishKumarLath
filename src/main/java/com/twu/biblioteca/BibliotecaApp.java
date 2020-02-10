package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void showMenu() throws IOException {
        int option;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Select an option:\n" +
                    "1. List of books\n" +
                    "2. Quit Application\n" +
                    "3. Checkout Book\n");
            option = Integer.parseInt(scanner.readLine());
            if (option == 1) {
                System.out.println(getBookList());
            } else if (option == 2) {
                System.out.println("Quiting Application...");
                break;
            } else if (option == 3){
                System.out.println("Enter the name of the book to be checked out:");
                String bookName = scanner.readLine();
                remove(bookName);
            } else {
                System.out.println("Please select a valid option!");
            }
        }
        scanner.close();
    }

    private void remove(String bookName) {
        int indexOfBook = Book.getIndexByName(bookName, bookList);
        if (indexOfBook == -1)
            System.out.println("Book Not Found\n");
        else
            bookList.remove(indexOfBook);
    }
}
