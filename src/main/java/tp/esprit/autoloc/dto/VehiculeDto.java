package tp.esprit.autoloc.dto;

import tp.esprit.autoloc.domain.CategorieVehicule;
import tp.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;

public record VehiculeDto(Long idVehicule, String immatriculation, String marque, String modele,
                          CategorieVehicule categorie, BigDecimal tarifJournalier,
                          StatutVehicule statut, Long agenceId) { }
