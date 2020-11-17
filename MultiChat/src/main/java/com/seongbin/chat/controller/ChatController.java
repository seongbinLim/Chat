package com.seongbin.chat.controller;

import com.seongbin.chat.dao.ChatRoomDao;
import com.seongbin.chat.dao.ChatRoomRepo;
import com.seongbin.chat.dto.ChatRoom;
import com.seongbin.chat.dto.ChatRoomForm;
import com.seongbin.chat.dto.ChatRoomVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {
    @Autowired
    private ChatRoomDao chatRoomDao;
    private final ChatRoomRepo chatRoomRepo;

    @GetMapping("/")
    public String chat() {
        return "chat";
    }

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", chatRoomRepo.findAll());
        return "rooms";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model) {
        ChatRoomVO room = chatRoomRepo.findRoomById(id);
        model.addAttribute("room", room);
        return "room";
    }

    @GetMapping("/new")
    public String make(Model model) {
        ChatRoomForm form = new ChatRoomForm();
        model.addAttribute("form", form);
        return "newRoom";
    }

    @PostMapping("/room/new")
    public String makeRoom(ChatRoomForm form) {
        ChatRoomVO chatVO = chatRoomRepo.createChatRoomVO(form.getName());
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(chatVO.getName());
        chatRoom.setRoomId(chatVO.getRoomId());
        chatRoomDao.save(chatRoom);
        return "redirect:/rooms";
    }
}
