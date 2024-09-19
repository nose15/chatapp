package org.studnia.chatapp.validators.email.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.studnia.chatapp.validators.email.UniqueEmailValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "User with such email already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
