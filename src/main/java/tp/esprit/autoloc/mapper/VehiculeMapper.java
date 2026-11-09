package tp.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tp.esprit.autoloc.domain.Vehicule;
import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.repository.AgenceRepository;

@Component
public class VehiculeMapper {
    private final AgenceRepository agenceRepository;

    public VehiculeMapper(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public Vehicule toEntity(VehiculeDto dto) {
        Vehicule vehicule = new Vehicule();
        vehicule.setIdVehicule(dto.idVehicule());
        vehicule.setImmatriculation(dto.immatriculation());
        vehicule.setMarque(dto.marque());
        vehicule.setModele(dto.modele());
        vehicule.setCategorie(dto.categorie());
        vehicule.setTarifJournalier(dto.tarifJournalier());
        vehicule.setStatut(dto.statut());
        vehicule.setAgence(dto.agenceId() == null ? null : agenceRepository.findById(dto.agenceId()).orElse(null));
        return vehicule;
    }

    public VehiculeDto toDto(Vehicule vehicule) {
        Long agenceId = vehicule.getAgence() == null ? null : vehicule.getAgence().getIdAgence();
        return new VehiculeDto(vehicule.getIdVehicule(), vehicule.getImmatriculation(), vehicule.getMarque(),
                vehicule.getModele(), vehicule.getCategorie(), vehicule.getTarifJournalier(),
                vehicule.getStatut(), agenceId);
    }
}
