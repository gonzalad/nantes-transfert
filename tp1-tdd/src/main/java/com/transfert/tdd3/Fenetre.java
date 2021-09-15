package com.transfert.tdd3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fenetre implements Component {
    private final List<Component> components = new ArrayList<>();

    @Override
    public void show(Writer writer) throws IOException {
        var content = new StringWriter();
        for (Component component : components) {
            component.show(content);
        }
        int contentSize = content.toString().length();
        String startOrEndLine = "_".repeat(2 + contentSize);
        writer.append(startOrEndLine)
            .append(System.lineSeparator())
            .append("|")
            .append(content.toString())
            .append("|")
            .append(System.lineSeparator())
            .append(startOrEndLine);
    }

    public void addComponent(Component component) {
        components.add(component);
    }
}
