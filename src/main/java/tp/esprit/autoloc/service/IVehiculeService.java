package tp.esprit.autoloc.service;

import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.dto.VehiculeRequestDto;

import java.util.List;

public interface IVehiculeService {
    List<VehiculeDto> retrieveAllVehicules();
    VehiculeDto addVehicule(VehiculeRequestDto vehicule);
    VehiculeDto updateVehicule(Long idVehicule, VehiculeRequestDto vehicule);
    VehiculeDto retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    VehiculeDto affecterVehiculeAEquipement(Long idVehicule,Long idEquipement);

}
