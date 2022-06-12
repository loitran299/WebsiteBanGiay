package com.example.websitebangiay.Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailUtils {
    private static String from = "superblue2992001@gmail.com";
    private Session session;

    public SendEmailUtils(Session session){
        this.session = session;
    }

    public static SendEmailUtils getInstance() {
        Session session;
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "vkwkrflgugsyvhzh");
            }
        });
        session.setDebug(true);
        return new SendEmailUtils(session);
    }




    public void sendEmail(String to, String subject, String txt) {
        try {
            MimeMessage message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(txt);
            Transport.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
