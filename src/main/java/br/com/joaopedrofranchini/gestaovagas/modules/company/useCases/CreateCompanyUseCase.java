package br.com.joaopedrofranchini.gestaovagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joaopedrofranchini.gestaovagas.exceptions.UserFoundException;
import br.com.joaopedrofranchini.gestaovagas.modules.company.entities.CompanyEntity;
import br.com.joaopedrofranchini.gestaovagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        return this.companyRepository.save(companyEntity);
    }
}
