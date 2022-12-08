package com.example.hospitalproject.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
import com.example.hospitalproject.domain.User;
import com.example.hospitalproject.domain.dto.UserRequest;
import com.example.hospitalproject.domain.dto.UserResponse;
import com.example.hospitalproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            return new UserResponse(id, "", "해당 id의 유저가 없습니다.");
        } else {
            User user = optionalUser.get();
            return new UserResponse(user.getId(), user.getUsername(), "");
        }
    }

    public UserResponse addUser(UserRequest dto) {
        Optional<User> selectedUser = userRepository.findByUsername(dto.getUsername());

        if(selectedUser.isEmpty()){
            User savedUser = userRepository.save(dto.toEntity());
            return new UserResponse(savedUser.getId(), savedUser.getUsername(), "등록이 완료되었습니다.");
        } else {
            return new UserResponse(null, dto.getUsername(), "해당 username은 이미 존재합니다.");
        }

    }
}