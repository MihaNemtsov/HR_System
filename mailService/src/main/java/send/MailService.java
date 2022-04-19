package send;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {
    public MailService() {}

    public void sendMail(String from, String textMessage) {
        String to = "email";

        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("email", "password");
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(to)); // Установка от кого будет отправлено письмо

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(from)); // Установка параметров рассылки и кому

            message.setSubject("Notification of database changes"); // Тема письма

            message.setText(textMessage); // Текст письма

            Transport.send(message);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
