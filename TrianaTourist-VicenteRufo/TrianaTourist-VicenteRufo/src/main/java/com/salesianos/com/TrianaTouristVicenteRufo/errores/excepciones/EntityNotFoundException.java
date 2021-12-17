package com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
