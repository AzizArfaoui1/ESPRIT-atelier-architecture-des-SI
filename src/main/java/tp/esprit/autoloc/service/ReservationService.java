package tp.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tp.esprit.autoloc.domain.Client;
import tp.esprit.autoloc.domain.Reservation;
import tp.esprit.autoloc.dto.ReservationResponseDTO;
import tp.esprit.autoloc.mapper.ReservationMapper;
import tp.esprit.autoloc.repository.ClientRepository;
import tp.esprit.autoloc.repository.ReservationRepository;

import java.util.List;


@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository,
                              ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public ReservationResponseDTO affecterReservationAClient(Long idReservation, String nom, String prenom) {
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);

        Client client = clientRepository.findByNomAndPrenom(nom, prenom);

        reservation.setClient(client);
        return reservationMapper.toDto(reservationRepository.save(reservation));
    }
}

