package com.example.test.controller;

import com.example.test.model.Order;
import com.example.test.service.order.OrderService;

import com.example.test.service.product.ProductService;
import com.example.test.service.typeproduct.TypeProductService;
import com.example.test.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;
    @Autowired
    private TypeProductService typeProductService;

    @Autowired
    private OrderValidator validator;


//    @GetMapping("/create-order")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("/order/create");
//        modelAndView.addObject("order", new Order());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-order")
//    public ModelAndView saveCustomer(@Validated @ModelAttribute("order") Order order, BindingResult bindingResult) throws ParseException {
//        ModelAndView modelAndView = new ModelAndView("/order/create");
//        validator.validate(order, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return modelAndView;
//        }
//        orderService.save(order);
//        modelAndView.addObject("message", "New order created successfully");
//        return modelAndView;
//    }
    @GetMapping("/orders")
    public ModelAndView listContract(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/order/list");
        modelAndView.addObject("orders", orderService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/edit-order/{id}")
    public ModelAndView showEditForm(@PathVariable("id")int id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/order/edit");
            modelAndView.addObject("order", order.get());
            modelAndView.addObject("products", productService.findAll());
            modelAndView.addObject("typeProducts", typeProductService.findAll());
            return modelAndView;
        } else {
            return new ModelAndView("/order/list");
        }
    }


    @PostMapping("/edit-order")
    public ModelAndView updateCustomer(@Validated @ModelAttribute("order") Order order, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/order/edit");
        validator.validate(order, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("products", productService.findAll());
            modelAndView.addObject("typeProducts", typeProductService.findAll());
            return modelAndView;
        }
        orderService.save(order);
        modelAndView.addObject("order", order);
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("typeProducts", typeProductService.findAll());
        modelAndView.addObject("message", "Order updated successfully");
        return modelAndView;
    }

}
