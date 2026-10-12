package tp.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.esprit.autoloc.domain.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
