package tp.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    @Operation(summary = "Lister les agences")
    @ApiResponse(responseCode = "200", description = "Liste des agences retournée")
    public List<Agence> getAll() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    public Agence getById(@PathVariable Long id) {
        Agence agence = agenceService.retrieveAgence(id);
        if (agence == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agence introuvable");
        }
        return agence;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer une agence")
    @ApiResponse(responseCode = "201", description = "Agence créée")
    public Agence create(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    public Agence update(@PathVariable Long id, @RequestBody Agence agence) {
        getById(id);
        agence.setIdAgence(id);
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Agence supprimée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    public void delete(@PathVariable Long id) {
        getById(id);
        agenceService.removeAgence(id);
    }
}
