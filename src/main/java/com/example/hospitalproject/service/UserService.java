package com.example.hospitalproject.service;

import com.example.hospitalproject.domain.User;
import com.example.hospitalproject.domain.dto.UserDto;
import com.example.hospitalproject.domain.dto.UserRequest;
import com.example.hospitalproject.domain.dto.UserResponse;
import com.example.hospitalproject.enums.UserRole;
import com.example.hospitalproject.exception.ErrorCode;
import com.example.hospitalproject.exception.HospitalReviewException;
import com.example.hospitalproject.repository.UserRepository;
import com.example.hospitalproject.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

//    @Value("${jwt.token.secret}")
//    private String secretKey;
    private Long expiredTimeMs = 1000 * 60 * 60l;

    public User getUserByUserName(String userName) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new HospitalReviewException(ErrorCode.USER_NOT_FOUNDED, ""));
        return user;
    }

    public UserDto join(String userName, String password) {
        // 중복 Check
        userRepository.findByUserName(userName).ifPresent(user -> {
            throw new HospitalReviewException(ErrorCode.DUPLICATED_USER_NAME, String.format("UserName %s is duplicated", userName));
        });

        // 위에서 에러가 안났다면 회원가입(DB에 저장)
        User user = User.builder()
                .userName(userName)
                .password(encoder.encode(password))
                .role(UserRole.USER)
                .build();

        User savedUser = userRepository.save(user);

        return UserDto.fromEntity(savedUser);
    }
//    public String login(String userName, String password) {
//        return JwtTokenUtil.createToken(userName, secretKey, expiredTimeMs);
//    }

    public UserResponse getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            return new UserResponse(id, "", "해당 id의 유저가 없습니다.");
        } else {
            User user = optionalUser.get();
            return new UserResponse(user.getId(), user.getUserName(), "");
        }
    }

    public UserResponse addUser(UserRequest dto) {
        Optional<User> selectedUser = userRepository.findByUserName(dto.getUserName());

        if(selectedUser.isEmpty()){
            User savedUser = userRepository.save(dto.toEntity());
            return new UserResponse(savedUser.getId(), savedUser.getUserName(), "등록이 완료되었습니다.");
        } else {
            return new UserResponse(null, dto.getUserName(), "해당 username은 이미 존재합니다.");
        }

    }
}