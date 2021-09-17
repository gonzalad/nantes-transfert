package com.transfert.tdd3;

public class Main {

    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        fenetre.addComponent(panelRecherche());
    }

    public static void main2(String[] args) {
        Panel fenetre = new Panel();
        setUp(fenetre);
    }

    /**
     * Aliment la fenêtre pour afficher la page recherche OF
     */
    private static void setUp(Container container) {
        Label label = new Label("toto:");
        container.addComponent(label);
    }

    private static Panel panelRecherche() {
        Label label = new Label("toto:");
        Panel recherche = new Panel();
        recherche.addComponent(label);
        return recherche;
    }
}
