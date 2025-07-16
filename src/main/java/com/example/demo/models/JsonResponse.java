//package com.example.demo.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class JsonResponse {
//    private String token;
//    private String username;
//    private String roles;
//}
package com.example.demo.models;

public class JsonResponse {
    private String token;
    private String username;
    private String roles;

    public JsonResponse() {}

    public JsonResponse(String token, String username, String roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
