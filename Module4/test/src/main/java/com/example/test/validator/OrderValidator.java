package com.example.test.validator;

import com.example.test.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order) target;
        int quantity = order.getQuantityProduct();
        if(quantity < 1){
            errors.rejectValue("quantityProduct", "quantityProduct.limit");
        }

    }
}
