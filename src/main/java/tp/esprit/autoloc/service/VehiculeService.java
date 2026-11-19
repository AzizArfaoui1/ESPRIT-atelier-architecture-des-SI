package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Equipement;
import tp.esprit.autoloc.domain.Vehicule;
import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.dto.VehiculeRequestDto;
import tp.esprit.autoloc.mapper.VehiculeMapper;
import tp.esprit.autoloc.repository.EquipementRepository;
import tp.esprit.autoloc.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;
    private final EquipementRepository equipementRepository;


    public VehiculeService(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper, EquipementRepository equipementRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
        this.equipementRepository = equipementRepository;
    }

    @Override
    public List<VehiculeDto> retrieveAllVehicules() {
        return vehiculeRepository.findAll().stream().map(vehiculeMapper::toDto).toList();
    }

    @Override
    public VehiculeDto addVehicule(VehiculeRequestDto vehicule) {
        return vehiculeMapper.toDto(vehiculeRepository.save(vehiculeMapper.toEntity(vehicule)));
    }

    @Override
    public VehiculeDto updateVehicule(Long idVehicule, VehiculeRequestDto vehicule) {
        Vehicule existing = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable"));
        vehiculeMapper.updateEntity(vehicule, existing);
        return vehiculeMapper.toDto(vehiculeRepository.save(existing));
    }

    @Override
    public VehiculeDto retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).map(vehiculeMapper::toDto).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public VehiculeDto affecterVehiculeAEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);

        List<Vehicule> vehicules = new ArrayList<>();

        if (equipement.getVehicules() != null) {
            vehicules = equipement.getVehicules();
        }

        vehicules.add(vehicule);
        equipement.setVehicules(vehicules);

        equipementRepository.save(equipement);
        return vehiculeMapper.toDto(vehicule);
    }

}
