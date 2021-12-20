package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple.NoPhotoRepeat;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoPhotoRepeatValidator implements ConstraintValidator<NoPhotoRepeat,Object> {

   String coverPhotos;
   String photo2;
   String photo3;

    @Override
    public void initialize(NoPhotoRepeat constraintAnnotation) {
        this.coverPhotos= constraintAnnotation.coverPhoto();
        this.photo2= constraintAnnotation.photo2();
        this.photo3= constraintAnnotation.photo3();

    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
            Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(coverPhotos);
            Object photo2Value = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo2);
            Object photo3Value = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo3);

            if (coverPhotoValue != null) {
                return !coverPhotoValue.equals(photo2Value) && !coverPhotoValue.equals(photo3Value) && !photo2Value.equals(photo3Value);
            } else {
                return coverPhotoValue == null;
            }
        }
    }

