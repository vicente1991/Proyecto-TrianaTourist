package com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id) {
        super("No se encontro el punto de interes con el siguiente id" + id);
    }
}
