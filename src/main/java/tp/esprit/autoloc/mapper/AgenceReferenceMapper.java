package tp.esprit.autoloc.mapper;

import org.mapstruct.Named;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.repository.AgenceRepository;

@Component
public class AgenceReferenceMapper {
    private final AgenceRepository agenceRepository;

    public AgenceReferenceMapper(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Named("agenceById")
    public Agence agenceById(Long agenceId) {
        if (agenceId == null) {
            return null;
        }
        return agenceRepository.findById(agenceId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agence introuvable"));
    }
}
