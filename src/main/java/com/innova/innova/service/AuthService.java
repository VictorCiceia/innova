package com.innova.innova.service;

import com.innova.innova.Entity.UserEntity;
import com.innova.innova.dto.AuthDto;
import com.innova.innova.dto.LoginDto;
import com.innova.innova.dto.RegisterDto;
import com.innova.innova.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.innova.innova.config.JwtService;
import com.innova.innova.Repository.UserRepository;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    public AuthDto login(LoginDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByEmail(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);

        return new AuthDto(token);
    }
    public AuthDto register(RegisterDto request) {
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode( request.getPassword()));
        user.setName(request.getName());
        user.setRole(Role.USER);
        userRepository.save(user);
        return new AuthDto(jwtService.getToken(user));
    }
}