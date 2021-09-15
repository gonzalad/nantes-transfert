package com.transfert.tdd3;

import java.io.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoutonTest {

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
    }

    @Test
    void showShouldDisplayStar() throws IOException {
        Bouton bouton = new Bouton();

        bouton.show(writer);

        assertThat(writer).asString().isEqualTo("*");
    }
}
