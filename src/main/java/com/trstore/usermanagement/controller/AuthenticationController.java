package com.trstore.usermanagement.controller;

import com.trstore.usermanagement.model.AuthenticationRequest;
import com.trstore.usermanagement.model.AuthenticationResponse;
import com.trstore.usermanagement.model.RegisterRequest;
import com.trstore.usermanagement.configuration.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.register(registerRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authSignIn(
            @RequestBody AuthenticationRequest registerRequest
    ){
        return ResponseEntity.ok().body(authenticationService.authenticate(registerRequest));

    }
}
