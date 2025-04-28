package main.com.example.demo.Service;

import org.springframework.stereotype.Service;

/**
 * An implementation of the MessageService interface for sending email messages.
 * The @Service annotation marks this class as a Spring component,
 * making it eligible for dependency injection.
 */
@Service
public class EmailService implements MessageService {

    /**
     * Sends an email message.
     * This method will be targeted by our AOP logging aspect.
     * @param recipient The recipient of the email message.
     * @return a confirmation string
     */
    @Override
    public String sendMessage(String recipient) {
        System.out.println("Executing EmailService.sendMessage() for recipient: " + recipient); // Added for clarity
        return "Email message sent to " + recipient;
    }
}