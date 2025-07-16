////without services
//// package com.example.demo;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////@RestController
////public class HelloWorld {
////    @Autowired
////    private MyService myService;
////
////    @GetMapping("/")
////    public String hello() {
////        System.out.println("Hello world");
////        return "Hello folks, welcome";
////    }
////}
//
//
////with services
////package com.example.demo.controllers;
////
////import com.example.demo.service.MyService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
////import org.springframework.web.bind.annotation.DeleteMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////@RestController
////public class HelloWorld {
////
////    @Autowired
////    private MyService myService;
////
////    @PostMapping("/post")
////    public String postMethod() {
////        return myService.postMethod();
////    }
////
////    @GetMapping("/")
////    public String hello() {
////        System.out.println("Hello world");
////        return myService.getWelcomeMessage();
////    }
////
////    @PutMapping("/put")
////    public String putMethod() {
////        return myService.putMethod();
////    }
////
////    @DeleteMapping("/delete")
////    public String deleteMethod() {
////        return myService.deleteMethod();
////    }
////}
//

//
//
//
//
//
////Day3
//package com.example.demo.controllers;
//
//import com.example.demo.models.Employee;

//import com.example.demo.service.MyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class HelloWorld {
//
//    @Autowired
//    private MyService myService;
//
//    @PostMapping("/post")
//    public String postMethod() {
//        return myService.postMethod();
//    }
//
//    @GetMapping("/")
//    public String hello() {
//        System.out.println("Hello world");
//        return myService.getWelcomeMessage();
//    }
//
//    @PutMapping("/put")
//    public String putMethod() {
//        return myService.putMethod();
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteMethod() {
//        return myService.deleteMethod();
//    }
//
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        return myService.getAllEmployees();
//    }
//
//    @PostMapping("/employee")
//    public String addEmployee(@RequestBody Employee emp) {
//        myService.addEmployee(emp);
//        return "Employee added successfully";
//    }
//}

//Day 7

//Day 10
//package com.example.demo.controllers;
//import com.example.demo.models.Employee;
//
//import com.example.demo.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class HelloWorld {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/")
//    public String route() {
//        return "Welcome to SpringBoot Security";
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getMethod();
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee/{empId}")
//    public Employee getEmployeeById(@PathVariable int empId) {
//        return employeeService.getEmployeeById(empId);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/employee")
//    public String addEmployee(@RequestBody Employee employee) {
//        return employeeService.addEmployee(employee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employee/{empId}")
//    public String updateEmployee(@PathVariable int empId) {
//        return employeeService.updateEmployee(empId);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/employee/{empID}")
//    public String deleteEmployee(@PathVariable int empID) {
//        return employeeService.deleteEmployeeById(empID);
//    }
//}
