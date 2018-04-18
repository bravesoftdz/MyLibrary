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

/**
 * This is example of generate SMS from email.
 * You can send email and another programme read email and send SMS.
 * @author Gvozdev A.N.
 * @version 1.0.0
 *
 */

public class Email2SMS {
	
	/**
	 * Parameters for sending email.
	 * @param email value has email address.
	 * @param numberUser value has telephone number.
	 * @param bodyMessage value has message which will be send.
	 * @param EmailData.MAIL_STATS_SMTP_HOST value has SMTP host.
	 * @param EmailData.MAIL_STATS_SSL_ENABLE value has status use SSL (true/false).
	 * @param EmailData.MAIL_STATS_SMTP_AUTH value has status authorisation (true/false).
	 * @param EmailData.MAIL_STATS_SMTP_PORT value has port for send email (integer).
	 */
	
	public void sendingSms(String email, String numberUser, String bodyMessage) {

		try {
			/**
			 * Initialisation properties
			 */
			Properties props = new Properties();
			props.put("mail.smtp.host", EmailData.MAIL_STATS_SMTP_HOST);
			props.put("mail.smtp.ssl.enable", EmailData.MAIL_STATS_SSL_ENABLE);
			props.put("mail.smtp.auth", EmailData.MAIL_STATS_SMTP_AUTH);
			props.put("mail.smtp.port", EmailData.MAIL_STATS_SMTP_PORT);

			/**
			 * Get session
			 */
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return (new PasswordAuthentication(EmailData.EMAIL_USER_NAME, EmailData.EMAIL_USER_PASSWORD));
				}
			}); 

			/**
			 * Specify the parameters and send mail.
			 * @param EmailData.EMAIL_USER_NAME value has email which from send email
			 * @param numberUser value has phone number which will be show in subject
			 * @param bodyMessage value has message
			 * @param msg value which consent all parameter for sending email
			 */
			Message msg = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(EmailData.EMAIL_USER_NAME);
			msg.setFrom(addressFrom);
			InternetAddress addressTo = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, addressTo);
			msg.setSubject(numberUser);
			msg.setText(bodyMessage);
			Transport.send(msg);

		} catch (MessagingException e) {
			System.err.println("Exception : " + e.toString());
		}

	}

}
