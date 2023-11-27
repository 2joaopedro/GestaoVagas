package br.com.joaopedrofranchini.gestaovagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //para criar um constructor com algumentos
public class ErrorMenssageDTO {
    private String menssagem;
    private String field;
}
