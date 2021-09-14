package com.example.ddd1.factory;

public class Ameublement {
    private final MeubleFactory meubleFactory;

    public Ameublement(MeubleFactory meubleFactory) {
        this.meubleFactory = meubleFactory;
    }

    public void meubler(Appartement appartement) {
        for (Piece piece: appartement.getPieces()) {
            piece.addFauteuil(meubleFactory.getFauteuil());
        }
    }
}
