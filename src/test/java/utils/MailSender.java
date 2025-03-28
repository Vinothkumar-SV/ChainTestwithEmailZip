package utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {

	public static void sendMailWithAttachment(File zipFilePath) {
		String from = "vinothkumarsv9@gmail.com";
		String password = "vgyr ksvz lwiu bjfv";
		String to = "vinothkumar.sanmugaraj@testleaf.com";
		String subject = "TestNG Report";
		String body = "Please find the attached TestNG Report ZIP.";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

//        # Email Configuration (Optional - for sending reports)
//        chaintest.email.enabled=true
//        chaintest.email.smtp.host=smtp.gmail.com
//        chaintest.email.smtp.port=587
//        chaintest.email.smtp.username=vinothkumarsv9@gmail.com  //out:krlhlqdvwtcsnxfz
//        chaintest.email.smtp.password=vgyr ksvz lwiu bjfv
//        chaintest.email.from=vinothkumarsv9@gmail.com
//        #chaintest.email.to=udayaprasath.karnan@testleaf.com,harrish.alaguponniah@testleaf.com,vineethbabu.rajendran@testleaf.com,bhuvanesh.moorthy@testleaf.com,saranya.shanmugam@testleaf.com,vinothkumar.sanmugaraj@testleaf.com
//        chaintest.email.to=vinothkumar.sanmugaraj@testleaf.com
//        chaintest.email.subject=Leaftaps Automation Test Report
//        chaintest.email.body=Please find the attached automation test report for the latest execution.

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);

			// Create multipart
			Multipart multipart = new MimeMultipart();

			// Body
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			multipart.addBodyPart(messageBodyPart);

			// Attachment
			MimeBodyPart attachmentPart = new MimeBodyPart();

			DataSource source = new FileDataSource(zipFilePath);
			attachmentPart.setDataHandler(new DataHandler(source));
			attachmentPart.setFileName("TestNG_Report.zip");
			multipart.addBodyPart(attachmentPart);

			// Set content
			message.setContent(multipart);

			// Send
			Transport.send(message);
			System.out.println("Email sent successfully with attachment...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
