package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testShouldReturnMovieDetailsAsString() {
        Movie movie = new Movie("Movie1", 2020, "Director1", 7.5);
        String movieDetails = "Movie1|2020|Director1|7.5\n";

        assertEquals(movie.toString(), movieDetails);
    }
}