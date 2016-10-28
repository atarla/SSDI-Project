package com.trendit.validator;

import com.trendit.model.User;
import com.trendit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by anusha on 10/26/2016.
 */

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass){
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","NotEmpty");
        if (user.getUsername().length()<6 || user.getUsername().length()>32){
         errors.rejectValue("username","Size.userForm.username");
                    }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname","NotEmpty");
        if (user.getUsername().length()<1 || user.getFullname().length()>32){
            errors.rejectValue("fullname","Size.userForm.fullname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","NotEmpty");
        if (user.getEmail().matches("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")){
            errors.rejectValue("email","Size.userForm.email");
        }
        if (userService.findByUsername(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
    }
}
