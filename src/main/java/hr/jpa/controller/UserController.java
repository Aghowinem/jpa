package hr.jpa.controller;

import hr.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/role/{roleName}")
    public ResponseEntity<?> AddRoleForAllUsers(@PathVariable  String roleName){
        userService.AddRoleForAllUsers(roleName);
        return ResponseEntity.ok(null);
    }
}
