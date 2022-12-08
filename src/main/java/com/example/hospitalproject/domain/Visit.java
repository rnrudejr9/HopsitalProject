package com.example.hospitalproject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")   // foreign key의 컬럼명
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "user_id")   // foreign key의 컬럼명
    private User user;

    private String disease;

    private float amount;
}