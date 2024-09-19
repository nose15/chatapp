package org.studnia.chatapp.validators.password.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.studnia.chatapp.validators.password.PasswordMatchingValidator;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchingValidator.class)
public @interface PasswordMatches {
    String message() default "Passwords don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
