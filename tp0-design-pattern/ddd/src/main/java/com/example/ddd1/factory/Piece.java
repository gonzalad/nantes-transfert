package com.example.ddd1.factory;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private List<Fauteuil> fauteuils = new ArrayList<>();

    public void addFauteuil(Fauteuil fauteuil) {
        fauteuils.add(fauteuil);
    }

    public List<Fauteuil> getFauteuils() {
        return fauteuils;
    }
}
