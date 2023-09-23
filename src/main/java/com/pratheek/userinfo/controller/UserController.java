package com.pratheek.userinfo.controller;

import com.pratheek.userinfo.UserinfoApplication;
import com.pratheek.userinfo.dto.UserDto;
import com.pratheek.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto savedUser = service.addUser(userDto);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDto> fetchUserById(@PathVariable Integer userId){
        return service.fetchUserById(userId);
    }
}
