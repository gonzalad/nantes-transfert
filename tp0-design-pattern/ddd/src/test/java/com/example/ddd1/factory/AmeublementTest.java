package com.example.ddd1.factory;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class AmeublementTest {


    @Test
    void testerAmeublementLouis14() {

        Piece piece = new Piece();
        Appartement appartement = new Appartement(List.of(piece));
        Ameublement ameublement = new Ameublement(new Louis14MeubleFactory());

        // appartement meublé
        ameublement.meubler(appartement);

        assertThat(piece.getFauteuils()).hasSize(1);
    }
/*
    @Test
    void testerAmeublementLouis14() {

        Appartement appartement = new Appartement();
        Ameublement ameublement = new Ameublement(new Annee50MeubleFactory());

        // appartement meublé
        ameublement.meubler(appartement);

        // rrr
    }*/
}
