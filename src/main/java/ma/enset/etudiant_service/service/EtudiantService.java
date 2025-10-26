package ma.enset.etudiant_service.service;



import ma.enset.etudiant_service.dto.EtudiantDTO;
import ma.enset.etudiant_service.entities.Etudiant;
import ma.enset.etudiant_service.feign.FiliereFeignClient;
import ma.enset.etudiant_service.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantService {
    private final EtudiantRepository repository;
    private final FiliereFeignClient feignClient;

    public EtudiantService(EtudiantRepository repository, FiliereFeignClient feignClient) {
        this.repository = repository;
        this.feignClient = feignClient;
    }

    public List<EtudiantDTO> getAll() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public EtudiantDTO getById(Long id) {
        Etudiant e = repository.findById(id).orElseThrow();
        return convertToDTO(e);
    }

    public EtudiantDTO save(EtudiantDTO dto) {
        Etudiant e = new Etudiant(null, dto.getNom(), dto.getEmail(), dto.getFiliereId());
        Etudiant saved = repository.save(e);
        return convertToDTO(saved);
    }

    private EtudiantDTO convertToDTO(Etudiant e) {
        EtudiantDTO dto = new EtudiantDTO();
        dto.setId(e.getId());
        dto.setNom(e.getNom());
        dto.setEmail(e.getEmail());
        dto.setFiliereId(e.getFiliereId());
        dto.setFiliere(feignClient.getFiliereById(e.getFiliereId()));
        return dto;
    }
}
