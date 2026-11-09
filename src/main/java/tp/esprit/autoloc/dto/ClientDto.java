package tp.esprit.autoloc.dto;

import java.time.LocalDate;

public record ClientDto(Long idClient, String nom, String prenom, String email,
                        String telephone, String numPermis, LocalDate dateInscription) { }
