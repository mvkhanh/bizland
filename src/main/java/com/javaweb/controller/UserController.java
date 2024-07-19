package com.javaweb.controller;

import com.javaweb.model.request.LoginRequest;
import com.javaweb.model.request.RegisterRequest;
import com.javaweb.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService service;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody RegisterRequest registerRequest, BindingResult bindingResult){
        try {
            if(bindingResult.hasErrors())
                return ResponseEntity.badRequest().body(
                        bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage)
                );
            if(!registerRequest.getPassword().equals(registerRequest.getRetypePassword()))
                throw new CredentialException("Password not match");
            return ResponseEntity.ok(service.createUser(registerRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest){
        try {
            return ResponseEntity.ok(service.login(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
