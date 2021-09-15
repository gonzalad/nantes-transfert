package com.example.ddd1.decorateur;

public class EnvoiMailReclamationService implements ReclamationService {

    private Object smtpSender;
    private ReclamationService delegate;

    public EnvoiMailReclamationService(ReclamationService delegate) {
        this.delegate = delegate;
    }

    @Override
    public void deposerReclamation(Reclamation reclamation) {
        delegate.deposerReclamation(reclamation);
        // smtpSender.sendMail(reclamation.getText())
    }
}
