package com.seongbin.chat.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.seongbin.chat.dto.ChatRoomVO;

import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepo {
    private Map<String, ChatRoomVO> chatRoomMap;

    @PostConstruct
    private void inti() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoomVO> findAll(){
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoomVO findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public ChatRoomVO createChatRoomVO(String name) {
        ChatRoomVO chatRoomVO = ChatRoomVO.create(name);
        chatRoomMap.put(chatRoomVO.getRoomId(), chatRoomVO);

        return chatRoomVO;
    }
}
