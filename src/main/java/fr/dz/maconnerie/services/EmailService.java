package fr.dz.maconnerie.services;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
