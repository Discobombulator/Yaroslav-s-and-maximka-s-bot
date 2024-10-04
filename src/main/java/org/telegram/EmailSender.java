package org.telegram;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;

public class EmailSender {
    private String username;
    private String password;
    public EmailSender(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean isValidEmail(String email){
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void sendEmail(String recipient, String subject, String body) {
        // Настройки для SMTP сервера
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Получение сессии с аутентификацией
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Отправка сообщения
            Transport.send(message);



        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public String getUsername(){
        return username;
    }
}
