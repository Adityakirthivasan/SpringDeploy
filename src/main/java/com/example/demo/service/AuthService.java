////Day 10
//package com.example.demo.service;
//
//import com.example.demo.jwt.JwtTokenProvider;
//import com.example.demo.models.JwtResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    public JwtResponse login(String username, String password) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        String token = jwtTokenProvider.generateToken(authentication);
//        return new JwtResponse(token, username, "ROLE_USER"); // Static role here
//    }
//}

//package com.example.demo.service;
//
//import com.example.demo.jwt.JwtTokenProvider;
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.models.Roles;
//import com.example.demo.models.UserDetailsDto;
//import com.example.demo.repo.RegisterDetailsRepository;
//import com.example.demo.repo.RegisterRepo;
//import com.example.demo.repo.RolesRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    RegisterRepo registerRepo;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    RegisterDetailsRepository registerDetailsRepository;
//
//    @Autowired
//    RolesRepo rolesRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public String addNewEmployee(UserDetailsDto register) {
//        RegisterDetails registerDetails = new RegisterDetails();
//        registerDetails.setEmpId(register.getEmpId());
//        registerDetails.setName(register.getName());
//        registerDetails.setEmail(register.getEmail());
//        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
//        registerDetails.setUserName(register.getUserName());
//        Set<Roles> roles = new HashSet<>();
//        for (String roleName : register.getRoleNames()) {
//            Roles role = rolesRepository.findByRoleName(roleName)
//                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
//            roles.add(role);
//        }
//        registerDetails.setRoles(roles);
//        System.out.println("Registration"+ registerDetails);
//        registerDetailsRepository.save(registerDetails);
//        return "Employee Added Successfully";
//    }
//
//    public String authenticateAndGenerateToken(String username, String password) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        String token = jwtTokenProvider.generateToken(authentication);
//        System.out.println("Generated Token: " + token); // Debug log
//        return  token;
////        return new JwtResponseDto(token, "Bearer");
//    }
//
//    public Optional<RegisterDetails> findByUsername(String userName) {
//        return registerRepo.findByUserName(userName);
//    }
//}
//
//package com.example.demo.service;
//
//import com.example.demo.jwt.JwtTokenProvider;
//import com.example.demo.models.JsonResponse;
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.models.Roles;
//import com.example.demo.models.UserDetailsDto;
//import com.example.demo.repo.RegisterDetailsRepository;
//import com.example.demo.repo.RegisterRepo;
//import com.example.demo.repo.RolesRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    RegisterRepo registerRepo;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    RegisterDetailsRepository registerDetailsRepository;
//
//    @Autowired
//    RolesRepo rolesRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public String addNewEmployee(UserDetailsDto register) {
//        RegisterDetails registerDetails = new RegisterDetails();
//        registerDetails.setEmpId(register.getEmpId());
//        registerDetails.setName(register.getName());
//        registerDetails.setEmail(register.getEmail());
//        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
//        registerDetails.setUserName(register.getUserName());
//
//        Set<Roles> roles = new HashSet<>();
//        for (String roleName : register.getRoleNames()) {
//            Roles role = rolesRepository.findByRoleName(roleName)
//                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
//            roles.add(role);
//        }
//
//        registerDetails.setRoles(roles);
//        registerDetailsRepository.save(registerDetails);
//        return "Employee Added Successfully";
//    }
//
//
//    public JsonResponse authenticate(RegisterDetails login) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        login.getUserName(), login.getPassword()
//                )
//        );
//
//        String token = jwtTokenProvider.generateToken(authentication);
//
//        RegisterDetails user = registerRepo.findByUserName(login.getUserName())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        String roleNames = user.getRoles()
//                .stream()
//                .map(Roles::getRoleName)
//                .collect(Collectors.joining(","));
//
//        return new JsonResponse(token, user.getUserName(), roleNames);
//    }
//
//    public Optional<RegisterDetails> findByUsername(String userName) {
//        return registerRepo.findByUserName(userName);
//    }
//}
//Aditya K 23EC002
package com.example.demo.service;

import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.models.JsonResponse;
import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Roles;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.repo.RegisterDetailsRepository;
import com.example.demo.repo.RegisterRepo;
import com.example.demo.repo.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepo rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());

        Set<Roles> roles = new HashSet<>();
        for (String roleName : register.getRoleNames()) {
            Roles role = rolesRepository.findByRoleName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }

        registerDetails.setRoles(roles);
        registerDetailsRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

    public JsonResponse authenticate(RegisterDetails login) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getUserName(), login.getPassword()
                )
        );

        String token = jwtTokenProvider.generateToken(authentication);

        String username = login.getUserName();
        String roleNames = authentication.getAuthorities().stream()
                .map(role -> role.getAuthority())
                .collect(Collectors.joining(","));

        return new JsonResponse(token, username, roleNames);
    }

    public Optional<RegisterDetails> findByUsername(String userName) {
        return registerRepo.findByUserName(userName);
    }
}
