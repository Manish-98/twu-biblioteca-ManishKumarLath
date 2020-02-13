package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Library {

    private final Stream console;
    private Collection<LibraryItems> books;
    private Collection<LibraryItems> movies;
    private Collection<User> users;
    private boolean quitState;
    private User currentUser;

    public Library(Stream console) {
        this.console = console;
        quitState = false;

        books = new ArrayList<>(Arrays.asList(new Book("Harry Potter", "JK Rowling", 2000),
                new Book("Da Vinci Code", "Dan Brown", 2003),
                new Book("Brida", "Paulo Coelho", 1990)));

        movies = new ArrayList<>(Arrays.asList(new Movie("Movie1", 2020, "Director1", 7.5),
                new Movie("Movie2", 2020, "Director2", 8)));

        users = new ArrayList<>(Arrays.asList(new User("123-1234", "qwerty"), new User("123-1235", "qwerty")));

        currentUser = new User("XXX-XXXX", "X");

    }

    public void process() throws IOException {
        do {
            console.output(MessageStore.getMenu());
            int option = Integer.parseInt(console.input());

            if (option == 7) {
                Validate validate = new Validate(console, users);
                currentUser = validate.getUser();
            } else {
                AppOperations operation = selectOperation(option);
                operation.execute();
            }
        } while (!quitState);
    }

    private AppOperations selectOperation(int option) {
        if (option == 1)
            return new GetListOfBooks(console, books);
        else if (option == 2) {
            quitState = true;
            return new QuitApplication(console);
        } else if (option == 3)
            return new CheckoutBook(console, books, currentUser);
        else if (option == 4)
            return new ReturnBook(console, books);
        else if (option == 5)
            return new GetListOfMovies(console, movies);
        else if (option == 6)
            return new CheckoutMovie(console, movies);
        else
            return new InvalidOption(console);
    }
}
