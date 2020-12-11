package dao;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;



public class SendMailDAO {
	
	public static void sendMail(final String from, final String password, String to, String subject, String body, boolean bodyIsHTML) throws MessagingException
	{
		Properties props = new Properties();
		//props.put("mail.strainsport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		// creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        
        Session session = Session.getDefaultInstance(props, auth);
        Message msg = new MimeMessage(session);
        
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] toAddresses = { new InternetAddress(to) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        if(bodyIsHTML)
        	msg.setContent(body, "text/html");
		else
			msg.setText(body);
		
 
        // sends the e-mail
        Transport.send(msg);
	}
	
}
