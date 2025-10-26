package ma.enset.etudiant_service.feign;

import ma.enset.etudiant_service.dto.Filiere;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "filiere-service", url = "http://localhost:8081/api/v1/filieres")
public interface FiliereFeignClient {
    @GetMapping("/{id}")
    Filiere getFiliereById(@PathVariable("id") Long id);
}
