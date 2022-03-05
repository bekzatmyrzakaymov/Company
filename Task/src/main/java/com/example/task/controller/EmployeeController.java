package com.example.task.controller;

import com.example.task.models.Employee;
import com.example.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/add")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Employee());

        return "addEmployee";
    }

    @PostMapping("/process_add")
    public String processRegister(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        List<Employee> listUsers = employeeService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "employeeList";
    }


    @GetMapping("/searchEmp")
    public String add(Model model) {
        List<Employee> listemployee = employeeService.listAll();
        model.addAttribute("employee", new Employee());
        return "index";
    }


    @PostMapping("/search")
    public String doSearchEmployee(@ModelAttribute("employeeSearchFormData") Employee formData, Model model) {
        Employee emp = employeeService.get(formData.getId());
        model.addAttribute("employee", emp);
        return "index";
    }


}
