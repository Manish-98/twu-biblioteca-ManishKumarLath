package com.twu.biblioteca;

public class Book extends LibraryItems{

    private final String name;
    private final String author;
    private final int publishingYear;
    private boolean checkedOut;

    public Book(String name, String author, int publishingYear) {

        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
        checkedOut = false;
    }

    public boolean hasName(String bookName) {
        return this.name.equals(bookName);
    }

    @Override
    public String toString() {
        return name + "|" +
                author + "|" +
                publishingYear + "\n";
    }

    public void checkout() {
        this.checkedOut = true;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkIn() {
        checkedOut = false;
    }
}
