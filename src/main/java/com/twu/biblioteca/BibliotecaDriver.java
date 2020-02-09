package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaDriver {

    public static void main(String[] args) throws IOException {
        BibliotecaApp biblioteca = new BibliotecaApp();
        System.out.println(biblioteca.getWelcomeMessage());
        biblioteca.showMenu();
    }

}
