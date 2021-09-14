package com.transfert.tdd2;

public class Main {
    public static void main(String[] args) {
        var echo = new Echo(new SysinReader(), new SysoutWriter());
        echo.echo();
        System.out.println("Program stopped by user");
    }
}
