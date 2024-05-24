package com.trstore.usermanagement.configuration;

import com.trstore.usermanagement.model.AuthenticationRequest;
import com.trstore.usermanagement.model.AuthenticationResponse;
import com.trstore.usermanagement.model.RegisterRequest;
import com.trstore.usermanagement.entity.UserEntity;
import com.trstore.usermanagement.service.UserService;
import com.trstore.usermanagement.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        if(!isUserNameExists(registerRequest.getUsername()) && !isEmailExists(registerRequest.getEmail())){
            var user = UserEntity.builder()
                    .firstName(registerRequest.getName())
                    .username(registerRequest.getUsername())
                    .email(registerRequest.getEmail())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .build();
            userRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse
                    .builder()
                    .token(jwtToken)
                    .build();
        }else {
            return AuthenticationResponse.builder()
                    .message("User Already Exists!")
                    .build();
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
    public boolean isUserNameExists(String userName){
        return userService.isUserNameExists(userName);
    }
    public boolean isEmailExists(String userName){
        return userService.isEmailExists(userName);
    }
}
