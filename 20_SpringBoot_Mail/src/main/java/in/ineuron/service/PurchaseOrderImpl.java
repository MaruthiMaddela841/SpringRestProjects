package in.ineuron.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service("service")
public class PurchaseOrderImpl implements IPurchaseOrder {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;

	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
		double amt=0.0;
		for(double price:prices) {
			amt=amt+price;
		}
		String msg=Arrays.toString(items)+" with price::"+Arrays.toString(prices)+" are purchased with amount::"+amt;
		String status=sendMail(msg,toEmails);
		return msg+"--->"+status;
	}

	private String sendMail(String msg, String[] toEmails) throws MessagingException {
		System.out.println("Sender Implementation class is::"+sender.getClass().getName());
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Open it to know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("amazon.jpg", new ClassPathResource("amazon.jpg"));
		sender.send(message);
		return "mail-sent";
	}

}
