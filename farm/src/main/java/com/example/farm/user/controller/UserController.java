package com.example.farm.user.controller;

import com.example.farm.common.dto.ResponseDto;
import com.example.farm.config.UserDetailsImpl;
import com.example.farm.user.dto.MyInfoResponseDto;
import com.example.farm.user.dto.RequestLogin;
import com.example.farm.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign")
    public void signup(@Valid @RequestBody RequestLogin requestLogin) {
        userService.signup(requestLogin);
    }

    @GetMapping("/mypage/{userId}")
    public ResponseDto<MyInfoResponseDto> myPage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.getMyInfo(userDetails.getUser());
    }
}
