package tp.esprit.autoloc.service;

import tp.esprit.autoloc.dto.AgenceDto;
import tp.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {
    List<AgenceDto> retrieveAllAgences();
    AgenceDto addAgence(AgenceDto agence);
    AgenceDto updateAgence(AgenceDto agence);
    AgenceDto retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);
    List<Agence> addAgences(List<Agence> agences);
}
