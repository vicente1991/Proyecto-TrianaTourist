package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador;

import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.POIRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple.UniqueLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLocationValidator implements ConstraintValidator<UniqueLocation,String> {

    @Autowired
    private POIRepository poiRepository;


    @Override
    public void initialize(UniqueLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !poiRepository.existsBylocation(s);
    }
}
