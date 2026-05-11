package com.reesdev.file_storage_api.service;

import com.reesdev.file_storage_api.dto.CreateUserRequest;
import com.reesdev.file_storage_api.dto.UserResponse;
import com.reesdev.file_storage_api.entity.User;
import com.reesdev.file_storage_api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserResponse createUser(@Valid CreateUserRequest request){
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail());
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
