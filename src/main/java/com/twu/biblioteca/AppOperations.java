package com.twu.biblioteca;

import java.io.IOException;
import java.util.Collection;

public interface AppOperations {

    void execute(Collection<Book> books) throws IOException;

}

class GetListOfBook implements AppOperations {

    private final Stream console;

    public GetListOfBook(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<Book> books) {
        StringBuilder bookListString = new StringBuilder();
        for (Book book : books) {
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
    public void execute(Collection<Book> books) throws IOException {
        console.output(MessageStore.getCheckoutPrompt());
        String bookInput = console.input();
        Book book = getBook(books, bookInput);

        if (book != null && !book.isCheckedOut()) {
            book.checkout();
            console.output(MessageStore.getSuccessfulCheckoutMessage());
        } else
            console.output(MessageStore.getUnsuccessfulCheckoutMessage());
    }

    private Book getBook(Collection<Book> books, String bookInput) {
        for (Book currentBook : books) {
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
    public void execute(Collection<Book> books) {
        console.output(MessageStore.getQuitMessage());
    }
}

class InvalidOption implements AppOperations {

    private final Stream console;

    public InvalidOption(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<Book> books) {
        console.output(MessageStore.getInvalidInputMessage());
    }
}

class ReturnBook implements AppOperations {

    private final Stream console;

    public ReturnBook(Stream console) {
        this.console = console;
    }

    @Override
    public void execute(Collection<Book> books) throws IOException {
        console.output(MessageStore.getReturnBookPrompt());
        String bookInput = console.input();
        Book book = getBook(books, bookInput);

        if (book != null && book.isCheckedOut()) {
            book.checkIn();
            console.output(MessageStore.getSuccessfulReturnMessage());
        }
    }

    private Book getBook(Collection<Book> books, String bookInput) {
        for (Book currentBook : books) {
            if (currentBook.hasName(bookInput))
                return currentBook;
        }
        return null;
    }
}