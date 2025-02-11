package org.example.demoserviciosapi.services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailService {
    private final String username = "idiomaensamblador@gmail.com"; // Sender's email
    private final String password = "*************"; // Use an app password for security

    /**
     * Sends an email using Gmail SMTP.
     *
     * @param to          Recipient's email.
     * @param subject     Email subject.
     * @param messageBody Email body content.
     * @return Success or error message.
     */
    public String sendEmail(String to, String subject, String messageBody) {
        try {
            // SMTP configuration
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Authenticate session
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Create and configure email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            // Send email
            Transport.send(message);

            return "Email successfully sent to " + to;
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
