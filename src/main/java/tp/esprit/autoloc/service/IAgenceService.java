package tp.esprit.autoloc.service;

import tp.esprit.autoloc.dto.AgenceDto;
import tp.esprit.autoloc.dto.AgenceRequestDto;

import java.util.List;

public interface IAgenceService {
    List<AgenceDto> retrieveAllAgences();
    AgenceDto addAgence(AgenceRequestDto agence);
    AgenceDto updateAgence(Long idAgence, AgenceRequestDto agence);
    AgenceDto retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);
}
