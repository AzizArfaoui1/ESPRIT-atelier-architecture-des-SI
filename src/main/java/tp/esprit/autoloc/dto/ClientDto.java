package tp.esprit.autoloc.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientDto(Long idClient,
                        @NotBlank(message = "Le nom est obligatoire") @Size(max = 100) String nom,
                        @NotBlank(message = "Le prénom est obligatoire") @Size(max = 100) String prenom,
                        @NotBlank(message = "L'email est obligatoire") @Email(message = "L'email doit être valide") String email,
                        @NotBlank(message = "Le téléphone est obligatoire") @Pattern(regexp = "^[+0-9() .-]{6,20}$", message = "Le téléphone doit être valide") String telephone,
                        @NotBlank(message = "Le numéro de permis est obligatoire") @Size(max = 50) String numPermis,
                        @PastOrPresent(message = "La date d'inscription ne peut pas être dans le futur") LocalDate dateInscription) { }
