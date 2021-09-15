package com.transfert.tdd3;

import java.io.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
    }

    @Test
    void showShouldUnderscoreWithInputSize() throws IOException {
        Input input = new Input(3);

        input.show(writer);

        assertThat(writer).asString().isEqualTo("___");
    }

    @Test
    void givenInvalidInputSizeThenThrowError() throws IOException {
        Throwable thrown = catchThrowable(() -> new Input(0));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        thrown = catchThrowable(() -> new Input(-1));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
