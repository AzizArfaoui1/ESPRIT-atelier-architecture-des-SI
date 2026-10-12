package tp.esprit.autoloc.service;

import tp.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    List<Paiement> retrieveAllPaiements();
    Paiement addPaiement(Paiement paiement);
    Paiement updatePaiement(Paiement paiement);
    Paiement retrievePaiement(Long idPaiement);
    void removePaiement(Long idPaiement);
    List<Paiement> addPaiements(List<Paiement> paiements);
}
