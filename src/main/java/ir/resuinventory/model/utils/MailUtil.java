package ir.resuinventory.model.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MailUtil {

    private static MailUtil mailUtil = new MailUtil();

    private MailUtil() {
    }

    public static MailUtil getMailUtil() {
        return mailUtil;
    }


//    ivir qbac sicn jcjh
//    smtp86800@gmail.com
    public void sendMail(String to, String subject, String body, boolean bodyIsHTML) throws MessagingException {


        // get a mail session
        // Sender's email ID needs to be mentioned
        String from = "smtp86800@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("smtp86800@gmail.com", "ivirqbacsicnjcjh");

            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        // create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // address the message
        Address fromAddress = new InternetAddress("smtp86800@gmail.com");
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        System.out.println("sending...");
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");

    }
}
