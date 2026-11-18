package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.dto.AgenceDto;
import tp.esprit.autoloc.dto.AgenceRequestDto;
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
    public AgenceDto addAgence(AgenceRequestDto agence) {
        return agenceMapper.toDto(agenceRepository.save(agenceMapper.toEntity(agence)));
    }

    @Override
    public AgenceDto updateAgence(Long idAgence, AgenceRequestDto agence) {
        Agence existing = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agence introuvable"));
        agenceMapper.updateEntity(existing, agence);
        return agenceMapper.toDto(agenceRepository.save(existing));
    }

    @Override
    public AgenceDto retrieveAgence(Long idAgence) {
        return agenceRepository.findById(idAgence).map(agenceMapper::toDto).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }
}
