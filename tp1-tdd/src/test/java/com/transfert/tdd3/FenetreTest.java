package com.transfert.tdd3;

import java.io.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FenetreTest {

    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
    }

    @Test
    void givenFenetreVideThenVerifyDisplay() throws IOException {
        Fenetre fenetre = new Fenetre();

        fenetre.show(writer);

        String expected = "__\n"
            + "||\n"
            + "__";
        assertThat(writer).asString().isEqualTo(expected);
    }

    @Test
    void givenFenetreWithSingleComponentThenVerifyDisplay() throws IOException {
        Fenetre fenetre = new Fenetre();
        fenetre.addComponent(new Input(3));

        fenetre.show(writer);

        String expected = "_____\n"
            + "|___|\n"
            + "_____";
        assertThat(writer).asString().isEqualTo(expected);
    }

    @Test
    void givenFenetreWithMultipleComponentThenVerifyDisplay() throws IOException {
        Fenetre fenetre = new Fenetre();
        fenetre.addComponent(new Input(3));
        fenetre.addComponent(new Bouton());

        fenetre.show(writer);

        String expected = "______\n"
            + "|___*|\n"
            + "______";
        assertThat(writer).asString().isEqualTo(expected);
    }
}
