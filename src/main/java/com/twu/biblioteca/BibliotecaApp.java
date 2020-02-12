package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaApp {

    private Stream console;

    //Constructor
    public BibliotecaApp(Stream console) {
        this.console = console;
    }

    //Public API
    public void start() throws IOException {
        console.output(MessageStore.getWelcomeMessage());
        Library library = new Library(console);
        library.process();
    }

}
