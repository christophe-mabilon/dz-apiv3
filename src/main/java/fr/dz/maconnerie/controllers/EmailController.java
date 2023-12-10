package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        emailService.sendSimpleMessage(to, subject, text);
    }
}