package com.transfert.tdd3;

import java.io.*;

public class Input implements Component {
    private final int size;

    public Input(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Paramètre size doit être supérieur à 0");
        }
        this.size = size;
    }

    @Override
    public void show(Writer writer) throws IOException {
        writer.append("_".repeat(size));
    }
}
