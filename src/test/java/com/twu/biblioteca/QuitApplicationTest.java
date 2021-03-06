package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class QuitApplicationTest {

    @Test
    public void testShouldDisplayQuitMessage() {
        Stream console = mock(Stream.class);
        QuitApplication quitApplication = new QuitApplication(console);

        quitApplication.execute();

        verify(console, times(1)).output("Quiting Application...");
    }
}