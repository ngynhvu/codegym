package com.example.validateuser.validator;

import com.example.validateuser.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phone = user.getPhoneNumber();
        if(phone == null || phone.isEmpty()){
            errors.rejectValue("phoneNumber", "phoneNumber.empty");
        }
        else{
            if (phone.length()>11 || phone.length()<10){
                errors.rejectValue("phoneNumber", "phoneNumber.length");
            }
            if (!phone.startsWith("0")){
                errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
            }
            if (!phone.matches("(^$|[0-9]*$)")){
                errors.rejectValue("phoneNumber", "phoneNumber.matches");
            }
        }

    }
}
