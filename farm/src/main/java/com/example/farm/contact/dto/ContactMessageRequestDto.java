package com.example.farm.contact.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageRequestDto {

    @Length(max = 500, message = "문의 내용은 500자를 넘을 수 없습니다.")
    private String content;
    @Length(max = 50, message = "닉네임은 50자를 넘을 수 없습니다.")
    private String userName;
}
