package tp.esprit.autoloc.dto;

import java.time.LocalDate;

public record ReservationResponseDTO(
        Long idReservation,
        LocalDate dateDebut,
        LocalDate dateFin,
        String statut,
        Long idClient,
        String nomClient,
        String prenomClient
) {
}
