package tp.esprit.autoloc.service;

import tp.esprit.autoloc.domain.Vehicule;
import tp.esprit.autoloc.dto.VehiculeDto;

import java.util.List;

public interface IVehiculeService {
    List<VehiculeDto> retrieveAllVehicules();
    VehiculeDto addVehicule(VehiculeDto vehicule);
    VehiculeDto updateVehicule(VehiculeDto vehicule);
    VehiculeDto retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);
}
