package com.example.ddd1.factory;

import java.util.List;

public class Appartement {
    private final List<Piece> pieces;

    public Appartement(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
