package br.com.joaopedrofranchini.gestaovagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopedrofranchini.gestaovagas.modules.candidate.CandidateEntity;
import br.com.joaopedrofranchini.gestaovagas.modules.candidate.UseCase.CreateCandidateUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;
    
    @PostMapping("/")
    // Este método acessa a requisição, colocando as informações contidas no corpo (body) da solicitação na instância da entidade CandidateEntity.
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
       try {
         var result = this.createCandidateUseCase.execute(candidateEntity);
         return ResponseEntity.ok().body(result);
       } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
