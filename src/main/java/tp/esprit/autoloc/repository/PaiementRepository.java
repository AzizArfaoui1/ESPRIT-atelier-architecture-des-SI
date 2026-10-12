package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
