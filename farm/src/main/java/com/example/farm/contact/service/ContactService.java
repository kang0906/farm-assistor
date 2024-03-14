package com.example.farm.contact.service;

import com.example.farm.alert.service.AlertService;
import com.example.farm.contact.dto.ContactMessageRequestDto;
import com.example.farm.contact.entity.ContactMessage;
import com.example.farm.contact.repository.ContactMessageRepository;
import com.example.farm.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactService {

    private final AlertService alertService;
    private final ContactMessageRepository contactMessageRepository;

    public Long createContactMessage(ContactMessageRequestDto requestDto, User user) {

        ContactMessage save = contactMessageRepository.save(new ContactMessage(requestDto.getContent(), requestDto.getUserName(), user));

        alertService.sendAlert( "[" + requestDto.getUserName() + "] 님의 문의 사항 \\n\\n" + requestDto.getContent() + "\\n=========================");

        return save.getContactMessageId();
    }
}
