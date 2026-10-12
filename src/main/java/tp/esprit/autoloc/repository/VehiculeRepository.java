package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

}
