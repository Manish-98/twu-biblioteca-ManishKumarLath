package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.shortThat;
import static org.mockito.Mockito.*;

public class QuitApplicationTest {

    @Test
    public void testShouldDisplayQuitMessage() {
        Stream console = mock(Stream.class);
        QuitApplication quitApplication = new QuitApplication(console);

        quitApplication.execute(new ArrayList<>());

        verify(console, times(1)).output("Quiting Application...");
    }
}