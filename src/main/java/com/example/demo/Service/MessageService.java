package main.com.example.demo.Service;

/**
 * A simple interface defining a message service.
 * This is used to demonstrate Dependency Injection.
 */
public interface MessageService {

    /**
     * Returns a message string.
     * @param recipient The recipient of the message.
     * @return a message
     */
    String sendMessage(String recipient);
}
