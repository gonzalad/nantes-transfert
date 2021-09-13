package com.transfert.tdd1;

import java.io.*;

public class SysinReader implements Reader{

    @Override
    public String read() {
        var in = new InputStreamReader(System.in);
        var br = new BufferedReader(in);
        try  {
            String line = br.readLine();
            if ("Q".equals(line)) {
                return null;
            }
            return line;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
