package tp.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;
    private Double montantTotal;
    private Boolean valide;

    @OneToOne
    private Reservation reservation;

    @OneToMany(mappedBy = "contrat")
    private Set<Paiement> paiements;
} 
