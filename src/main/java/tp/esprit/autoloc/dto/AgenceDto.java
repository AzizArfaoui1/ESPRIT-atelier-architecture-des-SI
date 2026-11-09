package tp.esprit.autoloc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AgenceDto(Long idAgence,
                        @NotBlank(message = "Le nom est obligatoire") @Size(max = 100) String nom,
                        @NotBlank(message = "La ville est obligatoire") @Size(max = 100) String ville,
                        @NotBlank(message = "L'adresse est obligatoire") @Size(max = 255) String adresse,
                        @NotBlank(message = "Le téléphone est obligatoire") @Pattern(regexp = "^[+0-9() .-]{6,20}$", message = "Le téléphone doit être valide") String telephone) { }
