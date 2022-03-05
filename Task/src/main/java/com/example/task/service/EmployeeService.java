package com.example.task.service;

import com.example.task.models.Employee;
import com.example.task.repo.EmployeeRepo;
import com.example.task.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee) {

//        if((!Validate.validate(employee.getEmail())) || (!Validate.validateName(employee.getFirstName())) ||
//                (!Validate.validateName(employee.getLastName()))) {
//            return;
//        }
        employeeRepo.save(employee);
    }

    public List<Employee> listAll() {
        return employeeRepo.findAll();
    }

    public Employee get(Long id) {
        return employeeRepo.findById(id).get();
    }

    public Employee getByEmail(String email){
        return employeeRepo.findByEmail(email);
    }
}
