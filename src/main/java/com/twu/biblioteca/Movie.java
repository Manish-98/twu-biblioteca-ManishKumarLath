package com.twu.biblioteca;

public class Movie extends LibraryItems{

    private final String name;
    private final int yearOfRelease;
    private final String director;
    private double rating;

    public Movie(String name, int yearOfRelease, String director, double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + "|" + yearOfRelease + "|" + director + "|" + rating + "\n";
    }
}
