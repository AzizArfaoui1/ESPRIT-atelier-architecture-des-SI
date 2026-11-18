package tp.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.dto.AgenceDto;
import tp.esprit.autoloc.dto.AgenceRequestDto;

@Component
public class AgenceMapper {
    public Agence toEntity(AgenceRequestDto dto) {
        return new Agence(null, dto.nom(), dto.ville(), dto.adresse(), dto.telephone(),
                null, null, null, null);
    }

    public void updateEntity(Agence agence, AgenceRequestDto dto) {
        agence.setNom(dto.nom());
        agence.setVille(dto.ville());
        agence.setAdresse(dto.adresse());
        agence.setTelephone(dto.telephone());
    }

    public AgenceDto toDto(Agence agence) {
        return new AgenceDto(agence.getIdAgence(), agence.getNom(), agence.getVille(),
                agence.getAdresse(), agence.getTelephone());
    }
}
