package ma.enset.etudiant_service.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filiere {
    private Long id;
    private String nom;
    private String responsable;
}

