//package com.example.demo.controllers;
//
//import com.example.demo.controllers.EmployeeController;
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.service.EmployeeService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class EmployeeControllerTest {
//
//    @Mock
//    EmployeeService employeeService;
//
//    @InjectMocks
//    EmployeeController employeeController;
//
//    @BeforeEach
//    public void init(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testRoute() {
//        String str = employeeController.route();
//        assertEquals("Welcome to SpringBoot Security", str);
//    }
//
//    @Test
//    void testGetMethod(){
//        RegisterDetails emp1 = new RegisterDetails();
//        RegisterDetails emp2 = new RegisterDetails();
//
//        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));
//        List<RegisterDetails> result = employeeController.getMethod();
//        assertEquals(2, result.size());
//    }
//}
package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//Aditya K 23EC002
import java.util.*;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMethod() {
        RegisterDetails emp1 = new RegisterDetails();
        emp1.setEmpId(1);
        emp1.setName("Ak");

        RegisterDetails emp2 = new RegisterDetails();
        emp2.setEmpId(2);
        emp2.setName("Ram");

        when(employeeService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));

        List<RegisterDetails> result = employeeController.getMethod();
        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        int empId = 1;
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(empId);
        emp.setName("Aji");

        when(employeeService.getEmployeeById(empId)).thenReturn(emp);

        RegisterDetails result = employeeController.getEmployeeById(empId);
        assertEquals(empId, result.getEmpId());
        assertEquals("Aji", result.getName());
    }

    @Test
    void testPostMethod() {
        RegisterDetails emp = new RegisterDetails();
        emp.setEmpId(10);
        emp.setName("David");
        emp.setEmail("david@email.com");
        emp.setPassword("test123");
        emp.setUserName("david123");

        String expected = "Employee Added Successfully";
        when(employeeService.addEmployee(emp)).thenReturn(expected);

        String result = employeeController.postMethod(emp);
        assertEquals(expected, result);
    }

    @Test
    void testPutMethod() {
        int empId = 2;
        String expected = "Updated Successfully";

        when(employeeService.updateEmployee(empId)).thenReturn(expected);
        String result = employeeController.putMethod(empId);

        assertEquals(expected, result);
    }

    @Test
    void testDeleteMethod() {
        int empId = 3;
        String expected = "Deleted Successfully";

        when(employeeService.deleteEmployeeById(empId)).thenReturn(expected);
        String result = employeeController.deleteMethod(empId);

        assertEquals(expected, result);
    }

    @Test
    void testRouteMethod() {
        String result = employeeController.route();
        assertEquals("Welcome to SpringBoot Security", result);
    }
}
