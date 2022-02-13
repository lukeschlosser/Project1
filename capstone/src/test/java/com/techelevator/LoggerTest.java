package com.techelevator;
import org.junit.Test;

import java.io.FileNotFoundException;


import static org.mockito.Mockito.*;

public class LoggerTest {

    Logger logger = mock(Logger.class);

    @Test
    public void logTest() throws FileNotFoundException {

        doNothing().when(logger).log("Log.txt");
        verify(logger,times(1));
    }





}
