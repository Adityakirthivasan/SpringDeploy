//
////
////package com.example.demo.models;
////
////
////public class Employee {
////    private int userid;
////    private String name;
////    private String job;
////
////    public Employee(int userid, String name, String job) {
////        this.userid = userid;
////        this.name = name;
////        this.job = job;
////    }
////
////    // Getters
////    public int getUserid() {
////        return userid;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public String getJob() {
////        return job;
////    }
////
////    // Setters
////    public void setUserid(int userid) {
////        this.userid = userid;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public void setJob(String job) {
////        this.job = job;
////    }
////}
//
////Day5 Task
////package com.example.demo.models;
////
////import jakarta.persistence.*;
////import lombok.*;
////
////import java.util.Date;
////
////@Data
////@AllArgsConstructor
////@NoArgsConstructor
////@Entity
////@Table(name = "employees")
////public class Employee {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private int empID;
////
////    private String empName;
////    private String email;
////    private String password;
////    private String gender;
////
////    @Temporal(TemporalType.DATE)
////    private Date dob;
////
////    private String role;
////}
//
//
////Day 6
////package com.example.demo.models;
////
////import jakarta.persistence.*;
////import lombok.*;
////
////import java.util.Date;
////
////@Data
////@AllArgsConstructor
////@NoArgsConstructor
////@Entity
////@Table(name = "employees")
////public class Employee {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private int empID;
////
////    private String empName;
////    private String email;
////    private String password;
////    private String gender;
////
////    @Temporal(TemporalType.DATE)
////    private Date dob;
////
////    private String role;
////}
//
////Day 6 Task
//package com.example.demo.models;
//
//import jakarta.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int empID;
//
//    private String empName;
//    private String email;
//    private String password;
//    private String gender;
//
//    @Temporal(TemporalType.DATE)
//    private Date dob;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Roles role;
//
//    // Getters and Setters (manually added)
//    public int getEmpID() {
//        return empID;
//    }
//
//    public void setEmpID(int empID) {
//        this.empID = empID;
//    }
//
//    public String getEmpName() {
//        return empName;
//    }
//
//    public void setEmpName(String empName) {
//        this.empName = empName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Date getDob() {
//        return dob;
//    }
//
//    public void setDob(Date dob) {
//        this.dob = dob;
//    }
//
//    public Roles getRole() {
//        return role;
//    }
//
//    public void setRole(Roles role) {
//        this.role = role;
//    }
//}
//
//
//

//Day 7
//Day 10
package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(nullable = false)
    private String empName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "empId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    )
    private Set<Roles> roles;
}
