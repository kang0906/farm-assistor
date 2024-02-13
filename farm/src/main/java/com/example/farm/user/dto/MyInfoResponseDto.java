package com.example.farm.user.dto;

import com.example.farm.user.entity.User;
import lombok.Getter;

@Getter
public class MyInfoResponseDto {
    private String email;
    private Long kakaoId;
    private String username;

    public MyInfoResponseDto(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.kakaoId = user.getKakaoId();
    }
}
