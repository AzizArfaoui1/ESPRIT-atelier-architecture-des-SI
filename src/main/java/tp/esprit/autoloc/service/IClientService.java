package tp.esprit.autoloc.service;

import tp.esprit.autoloc.dto.ClientDto;
import tp.esprit.autoloc.dto.ClientRequestDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> retrieveAllClients();
    ClientDto addClient(ClientRequestDto client);
    ClientDto updateClient(Long idClient, ClientRequestDto client);
    ClientDto retrieveClient(Long idClient);
    void removeClient(Long idClient);
}
