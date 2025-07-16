////Day 6
//package com.example.demo.repo;
//
//import com.example.demo.models.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
//
//    //  Find employee by email - useful for login/authentication
//    Employee findByEmail(String email);
//}
//
//

//Day 6 Task
//package com.example.demo.repo;
//
//import com.example.demo.models.Employee;
//import com.example.demo.models.Roles;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface
//
//EmployeeRepo extends JpaRepository<Employee, Integer> {
//
//    //  Used for login
//    Employee findByEmail(String email);
//
//    //  Find all employees by role
//    List<Employee> findByRole(Roles role);
//}

//Day 7
//Day 10
package com.example.demo.repo;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email); // ✅ Valid method
}
