package tp.esprit.autoloc.service;

import tp.esprit.autoloc.domain.Client;
import tp.esprit.autoloc.dto.ClientDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> retrieveAllClients();
    ClientDto addClient(ClientDto client);
    ClientDto updateClient(ClientDto client);
    ClientDto retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<Client> addClients(List<Client> clients);
}
