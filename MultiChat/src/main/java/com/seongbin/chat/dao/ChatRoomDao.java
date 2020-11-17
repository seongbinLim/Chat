package com.seongbin.chat.dao;

import java.util.List;

import com.seongbin.chat.dto.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomDao extends JpaRepository<ChatRoom, String> {
    public List<ChatRoom> findAll();
    public ChatRoom save(ChatRoom chatRoom);
	public ChatRoom findByRoomId(String chatRoomId);
}
