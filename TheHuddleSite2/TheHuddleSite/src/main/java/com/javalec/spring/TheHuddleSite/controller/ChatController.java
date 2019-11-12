package com.javalec.spring.TheHuddleSite.controller;

import com.javalec.spring.TheHuddleSite.model.Messaging;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Messaging sendMessage(@Payload Messaging ultMessage) {
        return ultMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Messaging addUser(@Payload Messaging ultMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", ultMessage.getSender());
        return ultMessage;
    }
}