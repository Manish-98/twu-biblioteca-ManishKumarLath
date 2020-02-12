package com.twu.biblioteca;

public class Movie extends LibraryItems{

    private final String name;
    private final int yearOfRelease;
    private final String director;
    private double rating;
    private boolean isCheckedOut;

    public Movie(String name, int yearOfRelease, String director, double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.director = director;
        this.rating = rating;
        this.isCheckedOut = false;
    }

    @Override
    public String toString() {
        return name + "|" + yearOfRelease + "|" + director + "|" + rating + "\n";
    }

    @Override
    public boolean isCheckedOut() {
        return false;
    }
}
