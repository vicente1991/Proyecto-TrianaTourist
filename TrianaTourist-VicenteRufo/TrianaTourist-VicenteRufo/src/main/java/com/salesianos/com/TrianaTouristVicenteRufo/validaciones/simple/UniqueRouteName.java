package com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.validador.UniqueRouteNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = UniqueRouteNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueRouteName {

    String message() default "Esta ruta ya fue creada";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
