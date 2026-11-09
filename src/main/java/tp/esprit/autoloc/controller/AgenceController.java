package tp.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import tp.esprit.autoloc.dto.AgenceDto;
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
    public List<AgenceDto> getAll() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une agence")

    public AgenceDto getById(@PathVariable Long id) {
        AgenceDto agence = agenceService.retrieveAgence(id);
        if (agence == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agence introuvable");
        }
        return agence;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer une agence")
    @ApiResponse(responseCode = "201", description = "Agence créée")
    public AgenceDto create(@Valid @RequestBody AgenceDto agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une agence")

    public AgenceDto update(@PathVariable Long id, @Valid @RequestBody AgenceDto agence) {
        getById(id);
        agence = new AgenceDto(id, agence.nom(), agence.ville(), agence.adresse(), agence.telephone());
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une agence")

    public void delete(@PathVariable Long id) {
        getById(id);
        agenceService.removeAgence(id);
    }
}
