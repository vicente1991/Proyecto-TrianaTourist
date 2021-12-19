package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = UniqueNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueName{


    String message() default "Esta categoria ya fue creada";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
