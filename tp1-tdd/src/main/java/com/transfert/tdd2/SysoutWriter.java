package com.transfert.tdd2;

public class SysoutWriter implements Writer {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
