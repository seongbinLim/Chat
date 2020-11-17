package com.seongbin.chat.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ChatMessage {
    @Id
    @Column(name="chat_room_id")
    private String chatRoomId;
    private String writer;
    private String message;
    @Enumerated(EnumType.STRING)
    private MessageType type;
    
}
