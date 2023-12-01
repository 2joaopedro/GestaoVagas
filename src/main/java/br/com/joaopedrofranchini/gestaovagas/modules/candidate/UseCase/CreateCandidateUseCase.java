package br.com.joaopedrofranchini.gestaovagas.modules.candidate.UseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaopedrofranchini.gestaovagas.exceptions.UserFoundException;
import br.com.joaopedrofranchini.gestaovagas.modules.candidate.CandidateEntity;
import br.com.joaopedrofranchini.gestaovagas.modules.candidate.CandidateRepository;

@Service // é uma camada de servico ou seja a regra de negocio
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateEntity execute(CandidateEntity candidateEntity) {
         this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(candidateEntity);
    }
}
