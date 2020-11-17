package com.seongbin.chat.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ChatRoom {
    @Id
    @Column(name="room_id")
    private String roomId;
    private String name;
}
