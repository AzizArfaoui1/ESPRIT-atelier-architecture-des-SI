package tp.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    @Operation(summary = "Lister les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules retournée")
    public List<VehiculeDto> getAll() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un véhicule")

    public VehiculeDto getById(@PathVariable Long id) {
        VehiculeDto vehicule = vehiculeService.retrieveVehicule(id);
        if (vehicule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable");
        }
        return vehicule;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un véhicule")
    @ApiResponse(responseCode = "201", description = "Véhicule créé")
    public VehiculeDto create(@RequestBody VehiculeDto vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un véhicule")

    public VehiculeDto update(@PathVariable Long id, @RequestBody VehiculeDto vehicule) {
        getById(id);
        vehicule = new VehiculeDto(id, vehicule.immatriculation(), vehicule.marque(), vehicule.modele(),
                vehicule.categorie(), vehicule.tarifJournalier(), vehicule.statut(), vehicule.agenceId());
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un véhicule")

    public void delete(@PathVariable Long id) {
        getById(id);
        vehiculeService.removeVehicule(id);
    }
}
