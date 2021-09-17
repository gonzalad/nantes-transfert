package com.transfert.tdd3;

import java.io.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PanelTest {

    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
    }

    @Test
    void givenPanelVideThenVerifyDisplay() throws IOException {
        Panel panel = new Panel();

        panel.show(writer);

        String expected = "";
        assertThat(writer).asString().isEqualTo(expected);
    }

    @Test
    void givenFenetreWithSingleComponentThenVerifyDisplay() throws IOException {
        Panel panel = new Panel();
        panel.addComponent(new Input(3));

        panel.show(writer);

        String expected = "___";
        assertThat(writer).asString().isEqualTo(expected);
    }

    @Test
    void givenFenetreWithMultipleComponentThenVerifyDisplay() throws IOException {
        Panel panel = new Panel();
        panel.addComponent(new Input(3));
        panel.addComponent(new Bouton());

        panel.show(writer);

        String expected = "___*";
        assertThat(writer).asString().isEqualTo(expected);
    }

}
