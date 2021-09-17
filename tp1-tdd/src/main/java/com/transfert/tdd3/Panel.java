package com.transfert.tdd3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Panel implements Container {
    private final List<Component> components = new ArrayList<>();

    @Override
    public void show(Writer writer) throws IOException {
        for (Component component: components) {
            component.show(writer);
        }
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }
}
