package com.transfert.tdd3;

import java.io.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabelTest {

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
    }

    @Test
    void showShouldUnderscoreWithInputSize() throws IOException {
        String value = "value";
        Label label = new Label(value);

        label.show(writer);

        assertThat(writer).asString().isEqualTo(value + ": ");
    }

    @Test
    void givenValueNullThenThrowError() throws IOException {
        Throwable thrown = catchThrowable(() -> new Label(null));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
