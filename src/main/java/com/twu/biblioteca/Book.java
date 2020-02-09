package com.twu.biblioteca;

public class Book {

    private final String name;
    private final String author;
    private final int publishingYear;

    public Book(String name, String author, int publishingYear) {

        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    @Override
    public String toString() {
        return name + "|" +
                author + "|" +
                publishingYear + "\n";
    }
}
