package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple.NoPhotoRepeat;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoPhotoRepeatValidator implements ConstraintValidator<NoPhotoRepeat,Object> {

   String[] fotos;

    @Override
    public void initialize(NoPhotoRepeat constraintAnnotation) {
        this.fotos= constraintAnnotation.fields();

    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        for(int i = 0; i< fotos.length; i++) {
            Object field = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(fotos[i]);
            for (int j = i + 1; j < fotos.length; j++) {
                Object field2 = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(fotos[j]);
                if (field.equals(field2)) {
                    return false;
                }
            }
        }
        return true;
    }
    }

