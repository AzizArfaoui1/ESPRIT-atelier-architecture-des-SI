package tp.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.dto.AgenceDto;

@Component
public class AgenceMapper {
    public Agence toEntity(AgenceDto dto) {
        return new Agence(dto.idAgence(), dto.nom(), dto.ville(), dto.adresse(), dto.telephone(),
                null, null, null, null);
    }

    public AgenceDto toDto(Agence agence) {
        return new AgenceDto(agence.getIdAgence(), agence.getNom(), agence.getVille(),
                agence.getAdresse(), agence.getTelephone());
    }
}
