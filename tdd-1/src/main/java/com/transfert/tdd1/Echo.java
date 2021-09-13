package com.transfert.tdd1;

public class Echo {
    private final Reader reader;
    private final Writer writer;

    public Echo(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void echo() {
        String message;
        do {
           message = reader.read();
           if (message != null) {
               writer.write(message);
           }
        } while (message != null);
    }
}
