package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador;

import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.RouteRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple.UniqueRouteName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteNameValidator implements ConstraintValidator<UniqueRouteName,String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(UniqueRouteName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !routeRepository.existsByName(s);
    }
}
