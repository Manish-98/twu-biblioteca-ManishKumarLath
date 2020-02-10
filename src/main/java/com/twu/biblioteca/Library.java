package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Library {

    private final Stream console;
    private Collection<Book> books;
    private boolean quitState;

    public Library(Stream console) {
        this.console = console;
        quitState = false;
        books = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "JK Rowling", 2000),
                new Book("Da Vinci Code", "Dan Brown", 2003),
                new Book("Brida", "Paulo Coelho", 1990)));
    }

    public void process() throws IOException {
        do {
            console.output(MessageStore.getMenu());
            int option = Integer.parseInt(console.input());
            execute(option);
        } while (!quitState);
    }

    private void execute(int option) throws IOException {
        AppOperations operations;

        if (option == 1)
            operations = new GetListOfBook(console);
        else if (option == 2) {
            quitState = true;
            operations = new QuitApplication(console);
        } else if (option == 3)
            operations = new CheckoutBook(console);
        else
            operations = new InvalidOption(console);

        operations.execute(books);
    }

}
