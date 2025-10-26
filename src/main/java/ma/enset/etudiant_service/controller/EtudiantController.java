package ma.enset.etudiant_service.controller;



import ma.enset.etudiant_service.dto.EtudiantDTO;
import ma.enset.etudiant_service.service.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantController {
    private final EtudiantService service;

    public EtudiantController(EtudiantService service) { this.service = service; }

    @GetMapping
    public List<EtudiantDTO> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public EtudiantDTO getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public EtudiantDTO save(@RequestBody EtudiantDTO etudiant) { return service.save(etudiant); }
}
