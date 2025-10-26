package ma.enset.etudiant_service.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDTO {
    private Long id;
    private String nom;
    private String email;
    private Long filiereId;   // FK vers filiere
    private Filiere filiere;  // Objet complet, rempli via Feign
}
