package com.example.hospitalproject.domain.dto;

import com.example.hospitalproject.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String password;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}