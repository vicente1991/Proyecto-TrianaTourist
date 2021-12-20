package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple;


import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador.NoPhotoRepeatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NoPhotoRepeatValidator.class)
public @interface NoPhotoRepeat {

    String message() default "Las fotos no deben coincidir";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] fields();

}
