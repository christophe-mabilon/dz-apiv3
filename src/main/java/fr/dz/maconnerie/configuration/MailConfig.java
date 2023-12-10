package fr.dz.maconnerie.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your-smtp-host");
        mailSender.setPort(12345);
        mailSender.setUsername("your-username");
        mailSender.setPassword("your-password");

        // Additional configuration (if needed)

        return mailSender;
    }
}