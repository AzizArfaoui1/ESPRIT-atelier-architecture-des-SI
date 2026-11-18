package tp.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tp.esprit.autoloc.domain.Vehicule;
import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.dto.VehiculeRequestDto;
import tp.esprit.autoloc.repository.AgenceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Component
public class VehiculeMapper {
    private final AgenceRepository agenceRepository;

    public VehiculeMapper(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public Vehicule toEntity(VehiculeRequestDto dto) {
        Vehicule vehicule = new Vehicule();
        updateEntity(vehicule, dto);
        return vehicule;
    }

    public void updateEntity(Vehicule vehicule, VehiculeRequestDto dto) {
        vehicule.setImmatriculation(dto.immatriculation());
        vehicule.setMarque(dto.marque());
        vehicule.setModele(dto.modele());
        vehicule.setCategorie(dto.categorie());
        vehicule.setTarifJournalier(dto.tarifJournalier());
        vehicule.setStatut(dto.statut());
        vehicule.setAgence(dto.agenceId() == null ? null : agenceRepository.findById(dto.agenceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agence introuvable")));
    }

    public VehiculeDto toDto(Vehicule vehicule) {
        Long agenceId = vehicule.getAgence() == null ? null : vehicule.getAgence().getIdAgence();
        return new VehiculeDto(vehicule.getIdVehicule(), vehicule.getImmatriculation(), vehicule.getMarque(),
                vehicule.getModele(), vehicule.getCategorie(), vehicule.getTarifJournalier(),
                vehicule.getStatut(), agenceId);
    }
}
