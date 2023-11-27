package br.com.joaopedrofranchini.gestaovagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopedrofranchini.gestaovagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    
    @PostMapping("/")
    // Este método acessa a requisição, colocando as informações contidas no corpo (body) da solicitação na instância da entidade CandidateEntity.
    public void createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
            System.out.println("Candidato ".concat(candidateEntity.getUsername()));
    }
}
