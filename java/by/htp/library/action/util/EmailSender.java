package by.htp.library.action.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import by.htp.library.constants.EmailData;

public class EmailSender {

	public void sendingEmail(String email, String subject, String bodyMessage) {

		try {

			Properties props = new Properties();
			props.put("mail.smtp.host", EmailData.MAIL_STATS_SMTP_HOST);
			props.put("mail.smtp.ssl.enable", EmailData.MAIL_STATS_SSL_ENABLE);
			props.put("mail.smtp.auth", EmailData.MAIL_STATS_SMTP_AUTH);
			props.put("mail.smtp.port", EmailData.MAIL_STATS_SMTP_PORT);

			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return (new PasswordAuthentication(EmailData.EMAIL_USER_NAME, EmailData.EMAIL_USER_PASSWORD));
				}
			}); 

			Message msg = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(EmailData.EMAIL_USER_NAME);
			msg.setFrom(addressFrom);
			InternetAddress addressTo = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, addressTo);
			msg.setSubject(subject);
			msg.setText(bodyMessage);
			Transport.send(msg);

		} catch (MessagingException e) {
			System.err.println("Exception : " + e.toString());
		}

	}
}
