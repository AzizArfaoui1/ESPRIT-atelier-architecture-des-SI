package tp.esprit.autoloc.service;

import tp.esprit.autoloc.domain.Reservation;
import tp.esprit.autoloc.dto.ReservationResponseDTO;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    Reservation retrieveReservation(Long idReservation);
    void removeReservation(Long idReservation);
    List<Reservation> addReservations(List<Reservation> reservations);
    ReservationResponseDTO affecterReservationAClient(Long idReservation, String nom, String prenom );
}
