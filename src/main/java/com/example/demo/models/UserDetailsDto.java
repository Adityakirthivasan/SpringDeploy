////Day 10
//package com.example.demo.models;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//public class UserDetailsDto {
//    private int empId;
//    private String empName; // 🔁 Was missing
//    private String email;
//    private String password;
//    private String userName;
//    private String gender;   // 🔁 Was missing
//    private LocalDate dob;   // 🔁 Was missing
//    private Set<String> roleNames;
//
//    // Getters and setters
//    public int getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(int empId) {
//        this.empId = empId;
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
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
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
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
//
//    public Set<String> getRoleNames() {
//        return roleNames;
//    }
//
//    public void setRoleNames(Set<String> roleNames) {
//        this.roleNames = roleNames;
//    }
//}
package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private String name;
    private String email;
    private String password;
    private String userName;
    private Set<String> roleNames;
}
