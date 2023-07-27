package com.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    // Constructeur de la classe ResourceNotFoundException.
    // Il prend un argument "message" qui sera utilisé pour décrire la raison de l'exception.
    public ResourceNotFoundException(String message) {
        // Appelle le constructeur de la classe parente (RuntimeException) avec le message en tant qu'argument.
        // Cela permet d'initialiser le message de l'exception à afficher lorsque celle-ci est levée.
        super(message);
    }
}
