package com.transfert.tdd3;

import java.io.*;

public class Label implements Component {
    private final String value;

    public Label(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Paramètre value obligatoire");
        }
        this.value = value;
    }

    @Override
    public void show(Writer writer) throws IOException {
        writer.append(value).append(": ");
    }
}
