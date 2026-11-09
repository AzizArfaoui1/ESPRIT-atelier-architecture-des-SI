package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tp.esprit.autoloc.domain.Vehicule;
import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.mapper.VehiculeMapper;
import tp.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeService(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public List<VehiculeDto> retrieveAllVehicules() {
        return vehiculeRepository.findAll().stream().map(vehiculeMapper::toDto).toList();
    }

    @Override
    public VehiculeDto addVehicule(VehiculeDto vehicule) {
        return vehiculeMapper.toDto(vehiculeRepository.save(vehiculeMapper.toEntity(vehicule)));
    }

    @Override
    public VehiculeDto updateVehicule(VehiculeDto vehicule) {
        return vehiculeMapper.toDto(vehiculeRepository.save(vehiculeMapper.toEntity(vehicule)));
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
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return vehiculeRepository.saveAll(vehicules);
    }
}
