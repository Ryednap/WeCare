package com.iot.backend.services.authentication.controller;

import com.iot.backend.services.authentication.model.AppUser;
import com.iot.backend.services.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @GetMapping("/dummy")
    public ResponseEntity<?> dummyRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("https://jsonplaceholder.typicode.com/todos/1"));
        return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    @GetMapping("/v1/medicine")
    public ResponseEntity<?> getAllMedicine() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-origin", "Master");
        headers.setLocation(URI.create("http://localhost:3000/api/v1/medicine"));
        return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }
}
