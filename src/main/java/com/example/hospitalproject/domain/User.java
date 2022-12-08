package com.example.hospitalproject.domain;
import com.example.hospitalproject.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}