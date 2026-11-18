package tp.esprit.autoloc.mapper;

import org.springframework.stereotype.Component;
import tp.esprit.autoloc.domain.Client;
import tp.esprit.autoloc.dto.ClientDto;
import tp.esprit.autoloc.dto.ClientRequestDto;

@Component
public class ClientMapper {
    public Client toEntity(ClientRequestDto dto) {
        return new Client(null, dto.nom(), dto.prenom(), dto.email(), dto.telephone(),
                dto.numPermis(), dto.dateInscription(), null);
    }

    public void updateEntity(Client client, ClientRequestDto dto) {
        client.setNom(dto.nom());
        client.setPrenom(dto.prenom());
        client.setEmail(dto.email());
        client.setTelephone(dto.telephone());
        client.setNumPermis(dto.numPermis());
        client.setDateInscription(dto.dateInscription());
    }

    public ClientDto toDto(Client client) {
        return new ClientDto(client.getIdClient(), client.getNom(), client.getPrenom(), client.getEmail(),
                client.getTelephone(), client.getNumPermis(), client.getDateInscription());
    }
}
