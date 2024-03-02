package com.example.farm.contact.controller;

import com.example.farm.common.dto.ResponseDto;
import com.example.farm.contact.dto.ContactMessageRequestDto;
import com.example.farm.contact.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contact")
    public ResponseDto<Long> createContactMessage(@Valid @RequestBody ContactMessageRequestDto requestDto) {
        Long contactMessageId = contactService.createContactMessage(requestDto, null);// todo : 로그인 기능 구현 시 추가
        return ResponseDto.success(contactMessageId);
    }
}
