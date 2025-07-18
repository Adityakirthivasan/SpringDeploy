////Day 10
//package com.example.demo.service;
//import com.example.demo.models.Employee;
//
//import com.example.demo.repo.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Employee user = employeeRepo.findByEmail(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found: " + username);
//        }
//
//        Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
//                .collect(Collectors.toSet());
//
//        return new User(user.getEmail(), user.getPassword(), authorities);
//    }
//}
package com.example.demo.service;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repo.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegisterDetails user = registerDetailsRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRoleName()))
                .collect(Collectors.toSet());

        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}
