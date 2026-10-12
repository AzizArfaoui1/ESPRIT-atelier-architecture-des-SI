package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
