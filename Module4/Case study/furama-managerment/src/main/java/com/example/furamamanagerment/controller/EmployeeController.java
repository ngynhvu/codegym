package com.example.furamamanagerment.controller;

import com.example.furamamanagerment.model.employee.Employee;
import com.example.furamamanagerment.service.employee.EmployeeService;
import com.example.furamamanagerment.service.employee.division.DivisionService;
import com.example.furamamanagerment.service.employee.education.EducationService;
import com.example.furamamanagerment.service.employee.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private PositionService positionService;


    @GetMapping("/create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("divisions", divisionService.findAll());
        modelAndView.addObject("educations", educationService.findAll());
        modelAndView.addObject("positions", positionService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }

    @GetMapping("/employees")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employeeService.findAll());
        return modelAndView;
    }
}
