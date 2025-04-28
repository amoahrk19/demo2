package main.com.example.demo.Service;

import org.springframework.stereotype.Service;

/**
 * An implementation of the MessageService interface for sending text messages.
 * The @Service annotation marks this class as a Spring component,
 * making it eligible for dependency injection.
 */
@Service
public class TextService implements MessageService {

    /**
     * Sends a text message.
     * This method will be targeted by our AOP logging aspect.
     * @param recipient The recipient of the text message.
     * @return a confirmation string
     */
    @Override
    public String sendMessage(String recipient) {
        System.out.println("Executing TextService.sendMessage() for recipient: " + recipient); // Added for clarity
        return "Text message sent to " + recipient;
    }
}
