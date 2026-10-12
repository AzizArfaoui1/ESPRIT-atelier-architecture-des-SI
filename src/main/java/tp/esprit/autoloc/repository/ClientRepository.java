package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
