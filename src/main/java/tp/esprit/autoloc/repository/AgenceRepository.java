package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {

}
