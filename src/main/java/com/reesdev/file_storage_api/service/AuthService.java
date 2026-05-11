package com.reesdev.file_storage_api.service;

import com.reesdev.file_storage_api.dto.LoginRequest;
import com.reesdev.file_storage_api.dto.LoginResponse;
import com.reesdev.file_storage_api.entity.User;
import com.reesdev.file_storage_api.exception.InvalidCredentialsException;
import com.reesdev.file_storage_api.repository.UserRepository;
import com.reesdev.file_storage_api.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new InvalidCredentialsException("Email Not Found"));

        boolean isPasswordMatch = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
                );

        if(!isPasswordMatch){
            throw new InvalidCredentialsException("Invalid Email or Password");
        }
        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
