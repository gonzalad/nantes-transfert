package com.example.ddd1.decorateur;

public class Main {
    public static void main(String[] args) {
        // Spring...
        ClientController controller = new ClientController(new EnvoiMailReclamationService(new ReclamationServiceMetier()));
        controller.run();
    }
}
