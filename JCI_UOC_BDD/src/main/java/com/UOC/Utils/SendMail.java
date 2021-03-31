package com.UOC.Utils;

import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.ini4j.InvalidFileFormatException;

//import ReadMailConfig.MailConfigReader;
import com.UOC.ReadResourceFiles.iniFileReader;



//import org.testng.annotations.Test;
public class SendMail{
	
	
public static void Executemail() throws InvalidFileFormatException, IOException 
{
	// Create object of Property file
    Properties props = new Properties();
    
	
	//MailConfigReader MailConfigReader = new MailConfigReader();
	//iniFileReader iniFileReader = new iniFileReader();
	iniFileReader.ReadINIFile();
	//MailConfigReader.mailConfigParameters();
	//MailConfigReader MailConfigReader = new MailConfigReader();
	//MailConfigReader.mailConfigParameters();
	String To = iniFileReader.To;
	String From = iniFileReader.From;
	String Subject = iniFileReader.Subject;
	String Body = iniFileReader.Body;
	
	// this will set host of server- you can change based on your requirement 
	props.put("mail.smtp.host", "mail.mindteck.com");
	
	// set the port of socket factory 
	//props.put("mail.smtp.socketFactory.port", "587");

	// set socket factory
	//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	
	props.put("mail.smtp.starttls.enable", "true");

	// set the authentication to true
	props.put("mail.smtp.auth", "true");

	// set the port of SMTP server
	props.put("mail.smtp.port", "587");

	// This will handle the complete authentication
	Session session = Session.getDefaultInstance(props,

			new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("amlan.biswas@mindteck.com", "6Gby0R");

				}

			});

	try {

		// Create object of MimeMessage class
		Message message = new MimeMessage(session);

		// Set the from address
		message.setFrom(new InternetAddress(From));

		// Set the recipient address
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(To));
        
                    // Add the subject link
		message.setSubject(Subject);

		// Create object to add multimedia type content
		BodyPart messageBodyPart1 = new MimeBodyPart();

		// Set the body of email
		messageBodyPart1.setText(Body);

		// Create another object to add another content
		MimeBodyPart messageBodyPart2 = new MimeBodyPart();

		// Mention the file which you want to send
		//String filename = "D:\\MindteckProjects\\Selenium\\CorsiumsuiteAutomation\\CorsiumPOMAutomation\\ExtentReport\\ExtentReportResults.html";
        String filename = System.getProperty("user.dir") + "\\ExtentReport\\ExtentReportResults.html";
		// Create data source and pass the filename
		DataSource source = new FileDataSource(filename);

		// set the handler
		messageBodyPart2.setDataHandler(new DataHandler(source));

		// set the file
		messageBodyPart2.setFileName("ExtentReportResults.html");

		// Create object of MimeMultipart class
		Multipart multipart = new MimeMultipart();

		// add body part 1
		multipart.addBodyPart(messageBodyPart2);

		// add body part 2
		multipart.addBodyPart(messageBodyPart1);

		// set the content
		message.setContent(multipart);
		
		

		// finally send the email
		Transport.send(message);

		System.out.println("=====Email Sent=====");

	} catch (MessagingException e) {

		throw new RuntimeException(e);

	}

}	

}
		 