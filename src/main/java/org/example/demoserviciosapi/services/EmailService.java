package org.example.demoserviciosapi.services;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailService {
    private final String username = "idiomaensamblador@gmail.com"; // introducir correo
    private final String password = "*************"; //introducir password
    public String sendEmail(String to, String subject, String messageBody) {
        try {
            // Configuración del servidor SMTP de Gmail
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Crear la sesión
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // Construcción del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            // Envío del mensaje
            Transport.send(message);
            return "Correo enviado exitosamente a " + to;
        } catch (Exception e) {
            return "Error al enviar el correo: " + e.getMessage();
        }
    }
}
