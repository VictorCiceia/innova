package com.innova.innova.controller;

import com.innova.innova.dto.RegisterDto;
import com.innova.innova.dto.UserDto;
import com.innova.innova.exception.ResourceNotFoundException;
import com.innova.innova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAll(){
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable String id) throws ResourceNotFoundException {
        return this.userService.findById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody RegisterDto user){
        return this.userService.save(user);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable String id, @RequestBody UserDto user){
        return this.userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
