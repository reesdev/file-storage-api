package com.reesdev.file_storage_api.service;

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
    public User createUser(User user){
        return  userRepository.save(user);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

}
