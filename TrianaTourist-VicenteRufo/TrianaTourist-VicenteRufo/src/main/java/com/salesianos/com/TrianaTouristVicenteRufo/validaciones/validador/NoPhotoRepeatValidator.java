package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple.NoPhotoRepeat;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoPhotoRepeatValidator implements ConstraintValidator<NoPhotoRepeat,String> {

    private String coverPhoto;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(NoPhotoRepeat constraintAnnotation) {
        coverPhoto = constraintAnnotation.coverPhoto();
        photo2 = constraintAnnotation.photo2();
        photo3 = constraintAnnotation.photo3();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(coverPhoto);
        Object photo2Value = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo2);
        Object photo3Value = PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(photo3);
        if (coverPhotoValue != null){
            return !coverPhotoValue.equals(photo2Value) && !coverPhotoValue.equals(photo3Value) && !photo2Value.equals(photo3Value);
        }else {
            return coverPhotoValue == null;
        }
    }
}
