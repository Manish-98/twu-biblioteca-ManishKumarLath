package com.twu.biblioteca;

public class BibliotecaDriver {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        System.out.println(biblioteca.getWelcomeMessage());
        System.out.println("\nList of Books:");
        System.out.println(biblioteca.getBookList());
    }

}