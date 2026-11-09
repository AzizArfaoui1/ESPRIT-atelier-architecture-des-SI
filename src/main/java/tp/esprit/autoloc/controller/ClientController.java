package tp.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import tp.esprit.autoloc.dto.ClientDto;
import tp.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary = "Lister les clients")
    @ApiResponse(responseCode = "200", description = "Liste des clients retournée")
    public List<ClientDto> getAll() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client")

    public ClientDto getById(@PathVariable Long id) {
        ClientDto client = clientService.retrieveClient(id);
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client introuvable");
        }
        return client;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un client")
    @ApiResponse(responseCode = "201", description = "Client créé")
    public ClientDto create(@Valid @RequestBody ClientDto client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")

    public ClientDto update(@PathVariable Long id, @Valid @RequestBody ClientDto client) {
        getById(id);
        client = new ClientDto(id, client.nom(), client.prenom(), client.email(), client.telephone(),
                client.numPermis(), client.dateInscription());
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un client")

    public void delete(@PathVariable Long id) {
        getById(id);
        clientService.removeClient(id);
    }
}
