package br.com.joaopedrofranchini.gestaovagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User já Existe");
    }
}
