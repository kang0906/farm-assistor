package com.example.farm.user.service;

import com.example.farm.common.dto.ResponseDto;
import com.example.farm.common.exception.ErrorCode;
import com.example.farm.common.exception.GlobalException;
import com.example.farm.user.dto.MyInfoResponseDto;
import com.example.farm.user.dto.RequestLogin;
import com.example.farm.user.entity.User;
import com.example.farm.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signup(RequestLogin requestLogin) {
        Optional<User> findUser = userRepository.findByEmail(requestLogin.getEmail());
        if (!findUser.isPresent()) {
            User user = new User(requestLogin.getEmail(), null, requestLogin.getUsername(), bCryptPasswordEncoder.encode(requestLogin.getPassword()));
            userRepository.save(user);
        } else {
            log.warn("존재하는 아이디 입니다.");
            throw new GlobalException(ErrorCode.EXIST_EMAIL);
        }
    }

    public ResponseDto<MyInfoResponseDto> getMyInfo(User user) {
        return ResponseDto.success(new MyInfoResponseDto(user));
    }
}
