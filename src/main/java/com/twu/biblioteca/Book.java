package com.twu.biblioteca;

import java.util.List;

public class Book {

    private final String name;
    private final String author;
    private final int publishingYear;

    public Book(String name, String author, int publishingYear) {

        this.name = name;
        this.author = author;
        this.publishingYear = publishingYear;
    }

    public static int getIndexByName(String bookName, List<Book> bookList) {
        for (int index = 0; index < bookList.size(); ++index) {
            if (bookList.get(index).name.equals(bookName))
                return index;
        }
        return -1;
    }

    @Override
    public String toString() {
        return name + "|" +
                author + "|" +
                publishingYear + "\n";
    }
}
