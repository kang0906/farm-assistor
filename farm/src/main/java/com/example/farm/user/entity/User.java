package com.example.farm.user.entity;

import com.example.farm.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private Long kakaoId;
    private String username;
    private String password;
    private LocalDateTime lastAccessDate;



    public User(String email, Long kakaoId, String username, String password) {
        this.email = email;
        this.kakaoId = kakaoId;
        this.username = username;
        this.password = password;
        this.lastAccessDate = LocalDateTime.now();
    }
}
