package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Client;
import tp.esprit.autoloc.dto.ClientDto;
import tp.esprit.autoloc.dto.ClientRequestDto;
import tp.esprit.autoloc.mapper.ClientMapper;
import tp.esprit.autoloc.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> retrieveAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDto).toList();
    }

    @Override
    public ClientDto addClient(ClientRequestDto client) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(client)));
    }

    @Override
    public ClientDto updateClient(Long idClient, ClientRequestDto client) {
        Client existing = clientRepository.findById(idClient)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client introuvable"));
        clientMapper.updateEntity(existing, client);
        return clientMapper.toDto(clientRepository.save(existing));
    }

    @Override
    public ClientDto retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).map(clientMapper::toDto).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }
}
