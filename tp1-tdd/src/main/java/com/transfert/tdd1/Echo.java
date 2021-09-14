package com.transfert.tdd1;

public class Echo {
    public String echo(String input, int maxSize) {
        if (input == null) {
            return null;
        }
        if (maxSize >= input.length()) {
            return input;
        }
        return input.substring(0, maxSize);
    }
}
