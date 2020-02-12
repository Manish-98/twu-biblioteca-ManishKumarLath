package com.twu.biblioteca;

import java.io.IOException;
import java.util.Collection;

public interface AppOperations {

    void execute(Collection<LibraryItems> books) throws IOException;

}

class GetListOfBooks implements AppOperations {

    private final Stream console;

    public GetListOfBooks(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> books) {
        StringBuilder bookListString = new StringBuilder();
        for (LibraryItems item : books) {
            Book book = (Book) item;
            if (!book.isCheckedOut())
                bookListString.append(book.toString());
        }
        display(String.valueOf(bookListString));
    }

    private void display(String booksString) {
        console.output(booksString);
    }
}

class CheckoutBook implements AppOperations {

    private final Stream console;

    public CheckoutBook(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> books) throws IOException {
        console.output(MessageStore.getCheckoutPrompt());
        String bookInput = console.input();
        Book book = getBook(books, bookInput);

        if (book != null && !book.isCheckedOut()) {
            book.checkout();
            console.output(MessageStore.getSuccessfulCheckoutMessage());
        } else
            console.output(MessageStore.getUnsuccessfulCheckoutMessage());
    }

    private Book getBook(Collection<LibraryItems> books, String bookInput) {
        for (LibraryItems currentItem : books) {
            Book currentBook = (Book) currentItem;
            if (currentBook.hasName(bookInput))
                return currentBook;
        }
        return null;
    }
}

class QuitApplication implements AppOperations {

    private final Stream console;

    public QuitApplication(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> books) {
        console.output(MessageStore.getQuitMessage());
    }
}

class InvalidOption implements AppOperations {

    private final Stream console;

    public InvalidOption(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> books) {
        console.output(MessageStore.getInvalidInputMessage());
    }
}

class ReturnBook implements AppOperations {

    private final Stream console;

    public ReturnBook(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> books) throws IOException {
        console.output(MessageStore.getReturnBookPrompt());
        String bookInput = console.input();
        Book book = getBook(books, bookInput);

        if (book != null && book.isCheckedOut()) {
            book.checkIn();
            console.output(MessageStore.getSuccessfulReturnMessage());
        } else
            console.output(MessageStore.getUnSuccessfulReturnMessage());
    }

    private Book getBook(Collection<LibraryItems> books, String bookInput) {
        for (LibraryItems currentItem : books) {
            Book currentBook = (Book) currentItem;
            if (currentBook.hasName(bookInput))
                return currentBook;
        }
        return null;
    }
}

class GetListOfMovies implements AppOperations {

    private final Stream console;

    public GetListOfMovies(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> movies) {
        StringBuilder movieListString = new StringBuilder();
        for (LibraryItems item : movies) {
            Movie movie = (Movie) item;
            if (!movie.isCheckedOut())
                movieListString.append(movie.toString());
        }
        display(String.valueOf(movieListString));
    }

    private void display(String movies) {
        console.output(movies);
    }
}

class CheckoutMovie implements AppOperations {

    private final Stream console;

    public CheckoutMovie(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<LibraryItems> movies) throws IOException {
        console.output(MessageStore.getCheckoutMoviePrompt());
        String movieInput = console.input();
        Movie movie = getMovie(movies, movieInput);

        if (movie != null && !movie.isCheckedOut())
            movie.checkout();
    }

    private Movie getMovie(Collection<LibraryItems> movies, String movieInput) {
        for (LibraryItems currentItem : movies) {
            Movie currentMovie = (Movie) currentItem;
            if (currentMovie.hasName(movieInput))
                return currentMovie;
        }
        return null;
    }
}