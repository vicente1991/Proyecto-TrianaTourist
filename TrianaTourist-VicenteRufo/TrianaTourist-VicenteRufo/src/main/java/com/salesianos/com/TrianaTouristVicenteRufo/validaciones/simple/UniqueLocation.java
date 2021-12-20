package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador.UniqueLocationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueLocationValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface UniqueLocation {

    String message() default "Esta localizacion esta en uso";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
