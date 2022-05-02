package com.iot.backend.services.authentication.controller;

import com.iot.backend.services.authentication.model.AppUser;
import com.iot.backend.services.authentication.service.RestService;
import com.iot.backend.services.authentication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;
    private final RestService restService;

    @Autowired
    public UserController(UserService userService, RestService restService) {
        this.userService = userService;
        this.restService = restService;
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
        return restService.createGetRequest("http://localhost:3000/api/v1/medicine");
    }

    @GetMapping("/v1/medicine/date/{date}/{status}")
    public ResponseEntity<?> getMedicineByDate(@PathVariable String date, @PathVariable String status) {
        log.info("Caught date " + date);
        return restService.createGetRequest("http://localhost:3000/api/v1/medicine/date/" + date + "/" + status);
    }

    @PostMapping("/v1/medicine")
    public ResponseEntity<?> postMedicine(@RequestBody Map<String, Object> payload) {
        log.info("Captured payload : " + payload);
        return restService.createPostRequest("http://localhost:3000/api/v1/medicine", payload);
    }

    @PutMapping("/v1/medicine/update/{id}/{status}")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @PathVariable String status) {
        log.info("Captured Parameters : id = " + id + " status = " + status);
        return restService.createPutRequest("http://localhost:3000/api/v1/medicine/update/" + id + "/" + status);
    }

    @DeleteMapping("v1/medicine/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable String id) {
        log.info("Captured Delete Request for id : " + id);
        return restService.createDeleteRequest("http://localhost:3000/api/v1/medicine/" + id);
    }

    @PostMapping("/ring")
    public ResponseEntity<?> ringHardware(@RequestBody Map<String, Object> payload) {
        log.info("Captured payload: " + payload);
        return restService.createRingRequest(payload);
    }
}

