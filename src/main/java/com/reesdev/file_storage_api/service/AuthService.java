package com.reesdev.file_storage_api.service;

import com.reesdev.file_storage_api.dto.LoginRequest;
import com.reesdev.file_storage_api.dto.LoginResponse;
import com.reesdev.file_storage_api.entity.User;
import com.reesdev.file_storage_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException("Email Not Found"));

        boolean isPasswordMatch = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
                );

        if(!isPasswordMatch){
            throw new RuntimeException("Invalid Password");
        }
        return new LoginResponse("Login Success");
    }
}
