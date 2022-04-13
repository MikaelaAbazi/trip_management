package com.example.trip_management.service;

import com.example.trip_management.exception.ResourceNotFoundException;
import com.example.trip_management.model.User;
import com.example.trip_management.repository.UserRepository;
import com.example.trip_management.service.IServices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserService implements IUserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        String encPwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encPwd);
        return userRepository.save(user);
    }


    @Override
    public List<User> viewUsers() {
        return userRepository.findAll();
    }

    @Override
    public User viewUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found"));
    }

    @Override
    public User updateUserById(User user, Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found"));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        String encPwd = bCryptPasswordEncoder.encode(user.getPassword());
        existingUser.setPassword(encPwd);

        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User not found"));

        userRepository.deleteById(id);
    }

}


