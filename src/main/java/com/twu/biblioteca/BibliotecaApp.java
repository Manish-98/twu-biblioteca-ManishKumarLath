package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<String> bookList;

    public BibliotecaApp() {
        bookList = new ArrayList<>();
        bookList.add("Harry Potter");
        bookList.add("Da Vinci Code");
        bookList.add("Brida");
    }



    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String getBookList() {
        StringBuilder listOfBooks = new StringBuilder();
        for (String book: bookList) {
            listOfBooks.append(book);
            listOfBooks.append("\n");
        }

        return String.valueOf(listOfBooks);
    }
}
