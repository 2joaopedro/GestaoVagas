package br.com.joaopedrofranchini.gestaovagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    // Ele valida se o campo username cotém espaço
    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O Campo (username) não deve conter espaço")
    private String username;

    // Ele valida se o campo email se é realmente um email
    @Email(message = "O campo (email) deve conter um e-mail válido")
    private String email;
    
    @NotBlank()
    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    private String password;
    
    private String description;
    private String curriculum;
}
