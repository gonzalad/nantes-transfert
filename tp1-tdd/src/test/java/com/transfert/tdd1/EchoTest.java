package com.transfert.tdd1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class EchoTest {

    @Test
    void givenInputNullThenVerifyNull() {
        Echo echo = new Echo();

        String result = echo.echo(null, 10);

        assertThat(result).isNull();
    }

    @Test
    void givenMaxSizeMoreThanInputNullThenVerifyEqualsInput() {
        Echo echo = new Echo();
        String input = "test";

        String result = echo.echo(input, 10);

        assertThat(result).isEqualTo(input);
    }
    @Test
    void givenMaxSizeEqualsInputNullThenVerifyEqualsInput() {
        Echo echo = new Echo();
        String input = "test";

        String result = echo.echo(input, input.length());

        assertThat(result).isEqualTo(input);
    }

    @Test
    void givenMaxSizeLessMoreThanInputNullThenVerifyEqualsInput() {
        Echo echo = new Echo();
        String input = "test";

        String result = echo.echo(input, 2);

        assertThat(result).isEqualTo("te");
    }
}
