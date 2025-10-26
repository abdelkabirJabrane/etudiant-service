package ma.enset.etudiant_service.repository;


import ma.enset.etudiant_service.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}

