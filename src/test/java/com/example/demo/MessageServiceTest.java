package test.com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for MessageService implementations.
 * @SpringBootTest loads the full Spring application context for testing.
 * This allows us to @Autowired Spring-managed beans into our test.
 */
@SpringBootTest
public class MessageServiceTest {

    // Dependency Injection in Test: Spring injects the specific service beans.
    @Autowired
    private TextService textService;

    @Autowired
    private EmailService emailService;

    /**
     * Test case to verify that the TextService bean is not null
     * and returns the expected message.
     */
    @Test
    void testTextServiceSendMessage() {
        // Assert that the injected service is not null
        assertNotNull(textService, "TextService should be injected");

        // Call the method we want to test
        String recipient = "Charlie";
        String message = textService.sendMessage(recipient);

        // Assert the expected output
        assertEquals("Text message sent to " + recipient, message, "The text message should match the expected value");
    }

    /**
     * Test case to verify that the EmailService bean is not null
     * and returns the expected message.
     */
    @Test
    void testEmailServiceSendMessage() {
        // Assert that the injected service is not null
        assertNotNull(emailService, "EmailService should be injected");

        // Call the method we want to test
        String recipient = "David";
        String message = emailService.sendMessage(recipient);

        // Assert the expected output
        assertEquals("Email message sent to " + recipient, message, "The email message should match the expected value");
    }
}
