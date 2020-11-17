package com.seongbin.chat.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seongbin.chat.dao.ChatRoomDao;
import com.seongbin.chat.dao.ChatRoomRepo;
import com.seongbin.chat.dto.ChatMessage;
import com.seongbin.chat.dto.ChatRoom;
import com.seongbin.chat.dto.ChatRoomVO;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Component
@RequiredArgsConstructor
public class WebSocketHandler2 extends TextWebSocketHandler {
    private final ChatRoomRepo chatRoomRepo;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("메세지 전송 = " + session + " : " + message.getPayload());
        String msg = message.getPayload();
        ChatMessage chatMessage = objectMapper.readValue(msg, ChatMessage.class);
        ChatRoomVO chatRoomVO = chatRoomRepo.findRoomById(chatMessage.getChatRoomId());
        chatRoomVO.handleMessage(session, chatMessage, objectMapper);
    }
    
}
