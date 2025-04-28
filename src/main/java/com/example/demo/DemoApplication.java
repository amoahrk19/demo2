package com.example.demo;

import com.example.demo.Service.EmailService;
import com.example.demo.Service.MessageService;
import com.example.demo.Service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final MessageService messageService;

    @Autowired
    public DemoApplication(@Qualifier("textService") MessageService messageService) {
        this.messageService = messageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Application Started ---");
        String textResult = messageService.sendMessage("User A");
        System.out.println("Result: " + textResult);
        System.out.println("--- Application Finished ---");
    }
}
