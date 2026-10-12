package tp.esprit.autoloc.service;

import tp.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Vehicule vehicule);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);
}
