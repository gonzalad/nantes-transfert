package com.example.ddd1.decorateur;

public class ClientController {

    private ReclamationService reclamationService;

    public ClientController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }

    void run() {
        Reclamation reclamation = new Reclamation();
        reclamationService.deposerReclamation(reclamation);
    }
}
