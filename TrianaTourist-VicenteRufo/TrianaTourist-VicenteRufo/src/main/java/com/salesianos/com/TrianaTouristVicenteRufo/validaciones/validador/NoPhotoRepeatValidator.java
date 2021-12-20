package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple.NoPhotoRepeat;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoPhotoRepeatValidator implements ConstraintValidator<NoPhotoRepeat,String> {

   String[] fotos;

    @Override
    public void initialize(NoPhotoRepeat constraintAnnotation) {
        this.fotos = constraintAnnotation.fotos();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       Object ob= PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(String.valueOf(fotos));

       for (int i=0; i< fotos.length;i++){
           for (int j= 0;j<fotos.length;j++)
               if(fotos[i]!=null && fotos[j]!=null)
           if(fotos[i].equals(fotos[j])){
               return true;
           }
       }return false;
    }
}
