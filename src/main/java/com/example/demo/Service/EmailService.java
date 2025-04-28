package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {

    @Override
    public String sendMessage(String recipient) {
        System.out.println("Executing EmailService.sendMessage() for recipient: " + recipient); // Added for clarity
        return "Email message sent to " + recipient;
    }
}