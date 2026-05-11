package com.reesdev.file_storage_api.service;

import com.reesdev.file_storage_api.dto.UserResponse;
import com.reesdev.file_storage_api.entity.User;
import com.reesdev.file_storage_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserResponse createUser(User user){
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
