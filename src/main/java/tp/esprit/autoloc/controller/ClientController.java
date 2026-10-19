package tp.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Client;
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
    public List<Client> getAll() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    public Client getById(@PathVariable Long id) {
        Client client = clientService.retrieveClient(id);
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client introuvable");
        }
        return client;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un client")
    @ApiResponse(responseCode = "201", description = "Client créé")
    public Client create(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client modifié"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        getById(id);
        client.setIdClient(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un client")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client supprimé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    public void delete(@PathVariable Long id) {
        getById(id);
        clientService.removeClient(id);
    }
}
