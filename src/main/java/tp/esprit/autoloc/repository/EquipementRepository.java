package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {

}
