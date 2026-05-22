package com.ecom.user.controllers;

import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;
import com.ecom.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    //use Lombok @Slf4j
    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        System.out.println("Request received @@@");
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        log.info("Request received for user: {}", id);
        log.trace("This is a TRACE LEVEL LOG");
        log.debug("This is a DEBUG LEVEL LOG");
        log.info("This is an INFO LEVEL LOG");
        log.warn("This is a WARN LEVEL LOG");
        log.error("This is an ERROR LEVEL LOG");
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return new ResponseEntity<>("User created successfully",  HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserRequest updateUserRequest) {
        boolean updated = userService.updateUser(id, updateUserRequest);
        if(updated) {
            return  ResponseEntity.ok("User updated successfully");
        }
        return ResponseEntity.notFound().build();
    }





}
