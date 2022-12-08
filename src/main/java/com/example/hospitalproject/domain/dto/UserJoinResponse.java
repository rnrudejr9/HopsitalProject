package com.example.hospitalproject.domain.dto;

import com.example.hospitalproject.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserJoinResponse {

    private Integer id;
    private String userName;
    private UserRole role;

    public static UserJoinResponse fromUser(UserDto user) {
        return new UserJoinResponse();
    }

}
