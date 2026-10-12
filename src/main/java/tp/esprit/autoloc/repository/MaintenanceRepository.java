package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

}
