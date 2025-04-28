package com.example.demo.Service;

import org.springframework.stereotype.Service;


@Service
public class TextService implements MessageService {
    @Override
    public String sendMessage(String recipient) {
        System.out.println("Executing TextService.sendMessage() for recipient: " + recipient);
        return "Text message sent to " + recipient;
    }
}
