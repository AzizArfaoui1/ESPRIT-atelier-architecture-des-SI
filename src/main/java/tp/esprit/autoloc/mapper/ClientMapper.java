package tp.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tp.esprit.autoloc.domain.Client;
import tp.esprit.autoloc.dto.ClientDto;

@Component
public class ClientMapper {
    public Client toEntity(ClientDto dto) {
        return new Client(dto.idClient(), dto.nom(), dto.prenom(), dto.email(), dto.telephone(),
                dto.numPermis(), dto.dateInscription(), null);
    }

    public ClientDto toDto(Client client) {
        return new ClientDto(client.getIdClient(), client.getNom(), client.getPrenom(), client.getEmail(),
                client.getTelephone(), client.getNumPermis(), client.getDateInscription());
    }
}
