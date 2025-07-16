//Day10
//package com.example.demo.controllers;
//
//import com.example.demo.models.JwtResponse;
//import com.example.demo.service.AuthService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/login")
//    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
//        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
//    }
//
//    @Data
//    public static class LoginRequest {
//        private String username;
//        private String password;
//
//}
//package com.example.demo.controllers;
//
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.models.UserDetailsDto;
//import com.example.demo.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    AuthService authService;
//
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody UserDetailsDto register){
//        return authService.addNewEmployee(register);
//    }
//
//    @PostMapping("/login")
//    public String Login(@RequestBody RegisterDetails login){
//        return authService.authenticateAndGenerateToken(login.getName(), login.getPassword());
//    }
//
//}
//
package com.example.demo.controllers;

import com.example.demo.models.JsonResponse;
import com.example.demo.models.RegisterDetails;
import com.example.demo.models.UserDetailsDto;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register) {
        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public ResponseEntity<JsonResponse> login(@RequestBody RegisterDetails login) {
        JsonResponse response = authService.authenticate(login);
        return ResponseEntity.ok(response);
    }
}
