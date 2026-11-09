package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.dto.AgenceDto;
import tp.esprit.autoloc.mapper.AgenceMapper;
import tp.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
public class AgenceService implements IAgenceService {
    private final AgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    public AgenceService(AgenceRepository agenceRepository, AgenceMapper agenceMapper) {
        this.agenceRepository = agenceRepository;
        this.agenceMapper = agenceMapper;
    }

    @Override
    public List<AgenceDto> retrieveAllAgences() {
        return agenceRepository.findAll().stream().map(agenceMapper::toDto).toList();
    }

    @Override
    public AgenceDto addAgence(AgenceDto agence) {
        return agenceMapper.toDto(agenceRepository.save(agenceMapper.toEntity(agence)));
    }

    @Override
    public AgenceDto updateAgence(AgenceDto agence) {
        return agenceMapper.toDto(agenceRepository.save(agenceMapper.toEntity(agence)));
    }

    @Override
    public AgenceDto retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence).map(agenceMapper::toDto).orElse(null);
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
