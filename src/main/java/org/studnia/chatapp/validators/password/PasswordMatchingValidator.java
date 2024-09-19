package org.studnia.chatapp.validators.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.studnia.chatapp.dtos.user.UserRequestDTO;
import org.studnia.chatapp.validators.password.annotations.PasswordMatches;

public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        UserRequestDTO userRequestDTO = (UserRequestDTO) obj;

        return userRequestDTO.password.equals(userRequestDTO.matchingPassword);
    }
}
