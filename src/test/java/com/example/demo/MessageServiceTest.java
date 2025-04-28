package com.example.demo;

import com.example.demo.Service.EmailService;
import com.example.demo.Service.TextService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private TextService textService;

    @Autowired
    private EmailService emailService;

    @Test
    void testTextServiceSendMessage() {
        assertNotNull(textService, "TextService should be injected");
        String recipient = "Charlie";
        String message = textService.sendMessage(recipient);
        assertEquals("Text message sent to " + recipient, message, "The text message should match the expected value");
    }


    @Test
    void testEmailServiceSendMessage() {
        assertNotNull(emailService, "EmailService should be injected");
         String recipient = "David";
        String message = emailService.sendMessage(recipient);
        assertEquals("Email message sent to " + recipient, message, "The email message should match the expected value");
    }
}
