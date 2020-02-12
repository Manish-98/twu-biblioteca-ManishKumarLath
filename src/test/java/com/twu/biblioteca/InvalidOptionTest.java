package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class InvalidOptionTest {

    @Test
    public void testShouldDisplayInvalidOptionMessage() {
        Stream console = mock(Stream.class);
        InvalidOption invalidOption = new InvalidOption(console);

        invalidOption.execute(new ArrayList<>());

        verify(console, times(1)).output("Please select a valid option!\n");
    }
}