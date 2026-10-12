package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
public class AgenceService implements IAgenceService {
    private final AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> agences) {
        return agenceRepository.saveAll(agences);
    }
}
