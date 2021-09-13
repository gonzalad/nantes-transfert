package com.transfert.tdd1;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EchoTest {

    private Reader readerMock;
    private Writer writerMock;
    private Echo echo;

    @BeforeEach
    void setUp() {
        readerMock = mock(Reader.class);
        writerMock = mock(Writer.class);
        echo = new Echo(readerMock, writerMock);
    }

    @Test
    void givenStopReadingWhenEchoThenSuccess() {
        when(readerMock.read()).thenReturn(null);

        echo.echo();

        verify(readerMock).read();
        verify(writerMock, never()).write(anyString());
    }

    @Test
    void givenReadWhenEchoThenVerifyWrite() {
        String message = "Word";
        when(readerMock.read())
            .thenReturn(message)
            .thenReturn(null);

        echo.echo();

        verify(writerMock).write(message);
    }

    @Test
    void givenMultipleReadWhenEchoThenVerifyWrite() {
        String message1 = "Hello";
        String message2 = "world";
        when(readerMock.read())
            .thenReturn(message1)
            .thenReturn(message2)
            .thenReturn(null);

        echo.echo();

        verify(writerMock).write(message1);
        verify(writerMock).write(message2);
    }
}
