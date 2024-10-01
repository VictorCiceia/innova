package com.innova.innova.controller;

import com.innova.innova.dto.AuthDto;
import com.innova.innova.dto.LoginDto;
import com.innova.innova.dto.RegisterDto;
import com.innova.innova.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto request)
    {
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthDto> register(@RequestBody RegisterDto request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}