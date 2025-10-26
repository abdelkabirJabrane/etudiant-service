package ma.enset.etudiant_service.entities;


import jakarta.persistence.*;
import lombok.*;
import ma.enset.etudiant_service.dto.Filiere;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private Long filiereId; // FK vers filiere

    @Transient
    private Filiere filiere; // Objet complet, sera rempli via Feign

    // Constructeur pour créer un Etudiant sans le champ Filiere
    public Etudiant(Long id, String nom, String email, Long filiereId) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.filiereId = filiereId;
    }

}

