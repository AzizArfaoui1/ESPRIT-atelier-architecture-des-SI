package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {

}
