package com.transfert.tdd3;

import java.io.*;

public class Bouton implements Component {
    public void show(Writer writer) throws IOException {
        writer.append('*');
    }
}
