package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple;


import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador.POINotMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = POINotMatchValidator.class)
public @interface POINotMatch {

    String message() default "Las fotos no deben coincidir";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();
    String photo2();
    String photo3();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        POINotMatch[] value();
    }

}
