package br.com.joaopedrofranchini.gestaovagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    // Ele valida se o campo username cotém espaço
    @Pattern(regexp = "^(?!\\s*$).+", message = "O Campo (username) não deve conter espaço")
    private String username;

    // Ele valida se o campo email se é realmente um email
    @Email(message = "O campo (email) deve conter um e-mail válido")
    private String email;
    
    @Length(min = 10, max = 100)
    private String password;
    
    private String description;
    private String curriculum;
}
