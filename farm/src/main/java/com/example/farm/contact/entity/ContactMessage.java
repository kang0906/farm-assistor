package com.example.farm.contact.entity;

import com.example.farm.common.entity.BaseEntity;
import com.example.farm.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactMessage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactMessageId;

    private String content;
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private User user;

    public ContactMessage(String content, String userName, User user) {
        this.content = content;
        this.userName = userName;
        this.user = user;
    }
}
