package com.example.ddd1.factory;

public class Louis14MeubleFactory implements MeubleFactory {
    @Override
    public Fauteuil getFauteuil() {
        return new Louis14Fauteuil();
    }
}
