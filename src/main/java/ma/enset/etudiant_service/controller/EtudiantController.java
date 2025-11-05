package ma.enset.etudiant_service.controller;

import ma.enset.etudiant_service.dto.EtudiantDTO;
import ma.enset.etudiant_service.service.EtudiantService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    // GET accessible aux ROLE_USER et ROLE_ADMIN
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<EtudiantDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public EtudiantDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST réservé aux ROLE_ADMIN
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public EtudiantDTO save(@RequestBody EtudiantDTO etudiant) {
        return service.save(etudiant);
    }
}
