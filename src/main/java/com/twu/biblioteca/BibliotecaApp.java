package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    //Declarations
    private List<Book> bookList;
    private Stream console;

    //Constructor
    public BibliotecaApp(Stream console) {
        bookList = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "JK Rowling", 2000),
                new Book("Da Vinci Code", "Dan Brown", 2003),
                new Book("Brida", "Paulo Coelho", 1990)));

        this.console = console;
    }

    //Public API
    public void start() throws IOException {
        console.output(MessageStore.getWelcomeMessage());
        int option;
        label:
        while (true) {
            console.output(MessageStore.getMenu());
            option = Integer.parseInt(console.input());
            switch (option) {
                case 1:
                    console.output(getBookList());
                    break;
                case 2:
                    console.output(MessageStore.getQuitMessage());
                    break label;
                case 3:
                    console.output(MessageStore.getCheckoutPrompt());
                    String bookName = console.input();
                    remove(bookName);
                    break;
                default:
                    console.output(MessageStore.getInvalidInputMessage());
                    break;
            }
        }
    }

    //Private
    private String getBookList() {
        StringBuilder listOfBooks = new StringBuilder();
        for (Book book : bookList) {
            listOfBooks.append(book);
        }
        return String.valueOf(listOfBooks);
    }

    private void remove(String bookName) {
        int indexOfBook = Book.getIndexByName(bookName, bookList);

        if (indexOfBook == -1) console.output(MessageStore.getUnsuccessfulCheckoutMessage());
        else {
            bookList.remove(indexOfBook);
            console.output(MessageStore.getSuccessfulCheckoutMessage());
        }
    }
}
