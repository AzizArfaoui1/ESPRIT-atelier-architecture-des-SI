package tp.esprit.autoloc.dto;

import tp.esprit.autoloc.domain.CategorieVehicule;
import tp.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record VehiculeDto(Long idVehicule,
                          @NotBlank(message = "L'immatriculation est obligatoire") @Size(max = 20) String immatriculation,
                          @NotBlank(message = "La marque est obligatoire") @Size(max = 50) String marque,
                          @NotBlank(message = "Le modèle est obligatoire") @Size(max = 50) String modele,
                          @NotNull(message = "La catégorie est obligatoire") CategorieVehicule categorie,
                          @NotNull(message = "Le tarif journalier est obligatoire") @DecimalMin(value = "0.01", message = "Le tarif doit être supérieur à zéro") BigDecimal tarifJournalier,
                          @NotNull(message = "Le statut est obligatoire") StatutVehicule statut,
                          @Positive(message = "L'identifiant de l'agence doit être positif") Long agenceId) { }
