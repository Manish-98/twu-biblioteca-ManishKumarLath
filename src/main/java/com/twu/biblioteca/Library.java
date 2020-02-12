package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Library {

    private final Stream console;
    private Collection<LibraryItems> books;
    private Collection<LibraryItems> movies;
    private boolean quitState;

    public Library(Stream console) {
        this.console = console;
        quitState = false;

        books = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "JK Rowling", 2000),
                new Book("Da Vinci Code", "Dan Brown", 2003),
                new Book("Brida", "Paulo Coelho", 1990)));

        movies = new ArrayList<>(Arrays.asList(new Movie("Movie1", 2020, "Director1", 7.5),
                new Movie("Movie2", 2020, "Director2", 8)));
    }

    public void process() throws IOException {
        do {
            console.output(MessageStore.getMenu());
            int option = Integer.parseInt(console.input());
            AppOperations operation = selectOperation(option);
            if (option < 5)
                operation.execute(books);
            else
                operation.execute(movies);
        } while (!quitState);
    }

    private AppOperations selectOperation(int option) {
        if (option == 1)
            return new GetListOfBooks(console);
        else if (option == 2) {
            quitState = true;
            return new QuitApplication(console);
        } else if (option == 3)
            return new CheckoutBook(console);
        else if (option == 4)
            return new ReturnBook(console);
        else if (option == 5)
            return new GetListOfMovies(console);
        else if (option == 6)
            return new CheckoutMovie(console);
        else
            return new InvalidOption(console);
    }
}
