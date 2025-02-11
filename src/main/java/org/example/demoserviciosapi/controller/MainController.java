package org.example.demoserviciosapi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.demoserviciosapi.services.EmailService;

public class MainController {
    private final EmailService emailService = new EmailService();

    @FXML
    private TextField recipientField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextArea messageField;
    @FXML
    private TextArea responseArea;

    // Handles the "Send Email" button click
    @FXML
    public void handleSendEmail() {
        String to = recipientField.getText().trim();
        String subject = subjectField.getText().trim();
        String message = messageField.getText().trim();

        if (to.isEmpty() || subject.isEmpty() || message.isEmpty()) {
            responseArea.setText("All fields are required.");
            return;
        }

        String response = emailService.sendEmail(to, subject, message);
        responseArea.setText(response);
    }
}
