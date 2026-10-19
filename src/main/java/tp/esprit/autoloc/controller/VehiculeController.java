package tp.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tp.esprit.autoloc.domain.Vehicule;
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
    public List<Vehicule> getAll() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public Vehicule getById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.retrieveVehicule(id);
        if (vehicule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable");
        }
        return vehicule;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un véhicule")
    @ApiResponse(responseCode = "201", description = "Véhicule créé")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public Vehicule update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        getById(id);
        vehicule.setIdVehicule(id);
        return vehiculeService.updateVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public void delete(@PathVariable Long id) {
        getById(id);
        vehiculeService.removeVehicule(id);
    }
}
