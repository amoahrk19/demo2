package main.com.example.demo;

import com.example.demo.service.EmailService;
import com.example.demo.service.MessageService;
import com.example.demo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main Spring Boot application class.
 * Demonstrates injecting specific implementations of MessageService.
 */
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // Dependency Injection (DI): Spring injects instances of TextService and EmailService.
    // Spring finds the @com.example.demo.Service annotated classes and injects them.
    // This shows how Spring manages multiple implementations of an interface (IoC).
    private final TextService textService;
    private final EmailService emailService;

    @Autowired // @Autowired is used for dependency injection
    public DemoApplication(TextService textService, EmailService emailService) {
        this.textService = textService;
        this.emailService = emailService;
    }

    public static void main(String[] args) {
        // This starts the Spring application context.
        // Spring scans for components (@Component, @com.example.demo.Service, @Aspect, etc.)
        // and manages their lifecycle (IoC).
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * This method is executed after the Spring application context is loaded.
     * We use the injected services here.
     * The calls to sendMessage() will trigger the com.example.demo.AOP logging aspect.
     * @param args command line arguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Application Started ---");

        // Call the service methods - this is where DI is used, and com.example.demo.AOP is applied.
        String textResult = textService.sendMessage("Alice");
        System.out.println("Result: " + textResult);

        System.out.println("---"); // Separator

        String emailResult = emailService.sendMessage("Bob");
        System.out.println("Result: " + emailResult);

        System.out.println("--- Application Finished ---");
        // Note: By default, a non-web Spring Boot app will shut down after CommandLineRunner finishes.
    }
}
