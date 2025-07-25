package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route() {
        return "Welcome to SpringBoot Security";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee")
    public List<RegisterDetails> getMethod() {
        return employeeService.getMethod();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employee/{empId}")
    public RegisterDetails getEmployeeById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody RegisterDetails employee) {
        return employeeService.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/{empId}")
    public String putMethod(@PathVariable int empId, @RequestBody RegisterDetails updatedEmployee) {
        return employeeService.updateEmployee(empId, updatedEmployee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empID}")
    public String deleteMethod(@PathVariable int empID) {
        return employeeService.deleteEmployeeById(empID);
    }
}
